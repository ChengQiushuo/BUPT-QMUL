package com;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dnsquery implements Runnable {
    private byte[] data;
    private int length;
    private InetAddress client;
    private int clientPort;
    public static int startNum = 0;
    public dnsquery( DatagramPacket dsReceive ) {
        length = dsReceive.getLength ();
        data = new byte[length];
        System.arraycopy (dsReceive.getData (),0,data,0,dsReceive.getLength () );
        client = dsReceive.getAddress ();
        clientPort = dsReceive.getPort ();
        System.out.println(bytesTohex(data));

    }

    public String bytesTohex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean flag = false;
            if (b < 0) flag = true;
            int absB = Math.abs(b);
            if (flag) absB = absB | 0x80;
            //System.out.println(absB & 0xFF);
            String tmp = Integer.toHexString(absB & 0xFF);
            if (tmp.length() == 1) { //转化的十六进制不足两位，需要补0
                hex.append("0");
            }
            hex.append(tmp.toLowerCase());
        }
        return hex.toString();
    }

    @Override
    public void run () {

        dnsheader dh = this.readHeader(this.data);
        dnsquestion dq = this.readQuesion ( this.data );

        if(localQuery (dq,dh)){
            System.out.println ("ok" );
        }
        else {
            requInternet(dq, dh);
        }

    }
    public dnsheader readHeader(byte[]data) {
        startNum = 0;
        byte[] temp = new byte[ 2 ];
        dnsheader dh = new dnsheader ();
        int i;
        for ( i = 0; i < 2 ; i++ ) {
          temp[ i ] = data[ startNum + i ];
        }
        startNum += 2;
        dh.setID ( tool.toShort ( temp ) );
        System.out.println("ID: "+bytesTohex(temp));

        for ( i = 0; i < 2 ; i++ ) {
            temp[ i ] = data[startNum + i ];
        }
        startNum += 2;
        dh.setFlag (tool.toShort ( temp ));
        System.out.println("Flag: "+bytesTohex(temp));

        for ( i = 0; i < 2 ; i++ ) {
            temp[ i ] = data[ startNum + i ];
        }
        startNum += 2;
        dh.setQdCount ( tool.toShort ( temp ));
        System.out.println("QdCount: "+bytesTohex(temp));

        for ( i = 0; i < 2 ; i++ ) {
            temp[ i ] = data[ startNum + i ];
        }
        startNum += 2;
        dh.setAnCount (tool.toShort ( temp ));
        System.out.println("An: "+bytesTohex(temp));

        for ( i = 0; i < 2 ; i++ ) {
            temp[ i ] = data[ startNum + i ];
        }
        startNum += 2;
        dh.setNsCount ( tool.toShort ( temp ) );
        System.out.println("NsCount: "+bytesTohex(temp));

        for ( i = 0; i < 2 ; i++ ) {
            temp[ i ] = data[ startNum + i ];
        }
        startNum += 2;
        dh.setArCount ( tool.toShort ( temp ));
        System.out.println("ArCount: "+bytesTohex(temp));

        return dh;
    }
    public dnsquestion readQuesion(byte[]data){
        byte[] temp = new byte[2];
        byte bTemp = 0;
        dnsquestion dq = new dnsquestion ();
        dq.setQdomianName (tool.getDomianName (data,bTemp));
        System.out.println( "QdomainName: "+dq.getQdomianName());
        startNum+=1;
        for ( int i = 0; i < 2 ; i++ ){
            temp[i] = data[i+startNum];
        }
        startNum += 2;
        dq.setqType ( tool.toShort ( temp ) );
        System.out.println( "QType: "+bytesTohex(temp));
        System.out.println( "QType: "+dq.getqType());
        for ( int i = 0; i < 2 ; i++ ){
            temp[i] = data[i+startNum];
        }
        startNum += 2;
        dq.setqClass ( tool.toShort ( temp ) );
        System.out.println( "QClass: "+bytesTohex(temp));
        return dq;
    }
    public Boolean localQuery(dnsquestion dq,dnsheader dh){
        dnsrelay dr = new dnsrelay ();
        //String ip = dr.getMap ().getOrDefault ( "www.bupt.com.cn","" );
        String ip = dr.getMap ().getOrDefault ( dq.getQdomianName (),"" );
        System.out.println ( Thread.currentThread ().getName ()+"查找结果为："+ip );
       if(!ip.equals ( "" )&&(dq.getqType ()==1)) {
           createResponsePackage(ip,dh,dq);
           return true;
       }
       else
           return false;

    }
    public void requInternet(dnsquestion dq,dnsheader dh){
        try {

            //InetAddress dnsServer = InetAddress.getByName ( "10.3.9.5" );
            InetAddress dnsServer = InetAddress.getByName ( dnsrelay.InternetServer );
            DatagramPacket sendPackage = new DatagramPacket ( data,length,dnsServer,53 );
            DatagramSocket sendSocket = new DatagramSocket (  );
            sendSocket.send ( sendPackage );
            byte []data_1 = new byte[1024];
            DatagramPacket inReceivedPacket = new DatagramPacket (data_1,data_1.length);
            sendSocket.receive ( inReceivedPacket );
            DatagramPacket responPacket = new DatagramPacket ( data_1,inReceivedPacket.getLength (),client,clientPort );
            sendSocket.close ();
            dnsrelay.ds.send (responPacket );
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
    public void createResponsePackage(String ip,dnsheader dh,dnsquestion dq){
        short flagTemp = 0;
        if (ip.equals ( "0.0.0.0" )){
            flagTemp = (short) 0x8583;
        }
        else{
            flagTemp = (short) 0x8580;
        }
        dnsheader dnsResponseH = new dnsheader ( dh.getID (),flagTemp,dh.getQdCount (),(short)1,(short)1,(short)0 );

        byte[] dnsResponByteH = tool.toByteArrayHeader ( dnsResponseH );

        byte[] dnsResponByteQ = tool.toByteArrayQuestion ( dq );

        dnsrr dnsResponAn = new dnsrr ( (short) 0xc00c,dq.getqType (),dq.getqClass (),3600*24,(short) 4, ip);
        byte[] dnsResponByteAn = tool.toByteArrayAn(dnsResponAn);

        dnsrr dnsResponNs = new dnsrr ( (short) 0xc00c, (short) 6, dq.getqClass (), 3600*24, (short) 0 ,null );
        byte[] dnsResponByteNs = tool.toByteArrayNs ( dnsResponNs);

        byte[] dnsResponse = tool.intergrationAll(dnsResponByteH,dnsResponByteQ,dnsResponByteAn,dnsResponByteNs,ip);

        DatagramPacket responPacket_1 = new DatagramPacket (dnsResponse ,dnsResponse.length, client,clientPort );
        try {
            dnsrelay.ds.send ( responPacket_1 );
        }
        catch (Exception e){
            e.printStackTrace ();
        }
    }
}
