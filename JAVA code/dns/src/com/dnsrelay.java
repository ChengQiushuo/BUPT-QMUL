package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;

public class dnsrelay {
    final static int  PORT = 53;
    private static Map<String,String> map = new HashMap<String, String> ();
    DatagramPacket dpReceive = null;
    static DatagramSocket ds = null;
    public static String InternetServer;
    public static String database;
    public Map<String, String> getMap () {
        return map;
    }
    public dnsrelay(){
        this.readToMap ();
    }
    private static Map<String,String> readToMap(){
        //String pathname = "D://IdeaProjects//dns//src//com//dnsrelay.txt";
        String pathname =database;
        try{
            FileReader reader = new FileReader ( pathname );
            BufferedReader br = new BufferedReader ( reader );
            String line;
            while ((line = br.readLine ())!= null){
                String []arr = line.split ( " " );
                //System.out.println(arr[0]);
                //System.out.println(arr[1]);
               map.put (arr[1],arr[0]);
            }
            br.close ();
        }
        catch (Exception E){
            E.printStackTrace ();
        }
        return map;
    }
    public void createScoket(){
        ExecutorService dnsPool = Executors.newFixedThreadPool (7);//创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        try {
            ds = new DatagramSocket(PORT);
            System.out.println ( "DNS Relay starts !" );
            byte[] data = new byte[1024];
            dpReceive = new DatagramPacket ( data,data.length );
            while (true)
            {
                try
                {
                    ds.receive ( dpReceive );

                } catch (IOException e) {
                    e.printStackTrace ();
                }
                dnsPool.execute ( new com.dnsquery(dpReceive));
            }

        }
        catch (IOException E){
            E.printStackTrace ();
        }
    }

    public static void main(String args[]){
        if(args[0]!=null&&args[1]!=null) {
            InternetServer = args[0];
            database = args[1];
        }
        dnsrelay r  = new dnsrelay ();
        r.readToMap ();
        r.createScoket ();

     }
}
