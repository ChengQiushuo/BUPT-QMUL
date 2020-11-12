package com;

public class tool {
    public static short[] toShortArray(byte[] src) {
        int count = src.length >> 1;
        short[] dest = new short[ count ];
        for ( int i = 0 ; i < count ; i++ ) {
            dest[ i ] = (short) ( ( src[ i * 2 ] & 0xff ) | ( ( src[ 2 * i + 1 ] & 0xff ) << 8 ) );
        }
        return dest;
    }
    public static short toShort(byte[] b){
        return toShort(b, 0);
    }
    public static short toShort(byte[] b,int offset){
        return (short) (((b[offset] & 0xff) << 8) | (b[offset + 1] & 0xff));
    }
    public static String getDomianName(byte []data, byte stopNum){
        StringBuffer domainName = new StringBuffer ( );
        int tempNum = 0;
        String strTemp = null;
        byte[] tempArr = new byte[0];
        int tempStart = dnsquery.startNum;
        while((data[dnsquery.startNum])!=stopNum && dnsquery.startNum<data.length ){
            if(dnsquery.startNum != tempStart)
                domainName.append (".");
            tempNum =  (int)data[dnsquery.startNum];
            dnsquery.startNum++;
            tempArr = new byte[tempNum];
           for(int i = 0;i < tempNum;i++){
               tempArr[i] = data[dnsquery.startNum];
               dnsquery.startNum++;
           }
            try {
                strTemp  = new String ( tempArr,"ISO8859-1" );
            }
            catch (Exception E){
                E.printStackTrace ();
            }
           domainName.append ( strTemp );
        }
        return domainName.toString ();
    }

    public static byte[] toByteArrayHeader(dnsheader dh){
        byte[] data = new byte[12];
        int startNum = 0;
        byte[] byteTemp = new byte[2];
        tool.assignValue ( startNum,data,byteTemp,dh.getID () );
        startNum +=2;
        tool.assignValue ( startNum,data,byteTemp,dh.getFlag () );
        startNum +=2;
        tool.assignValue ( startNum,data,byteTemp,dh.getQdCount () );
        startNum +=2;
        tool.assignValue ( startNum,data,byteTemp,dh.getAnCount () );
        startNum +=2;
        tool.assignValue ( startNum,data,byteTemp,dh.getNsCount () );
        startNum +=2;
        tool.assignValue ( startNum,data,byteTemp,dh.getArCount () );
        startNum +=2;
        return data;

    }
    public static byte[] toByteArrayQuestion(dnsquestion  dq){
        byte[] data = new byte[dq.getQdomianName ().length ()+2+4];
        int startNum = 0;
        byte[] byteTemp = new byte[2];
        byte[] domainToByteArray = new byte[dq.getQdomianName ().length ()+2];
        {
            int startNum_1 = 0;
            String [] domianArray = dq.getQdomianName ().split ( "\\." );
            for(String eachDomian: domianArray){
                domainToByteArray[startNum_1++] = (byte) eachDomian.length ();
                for(char c: eachDomian.toCharArray ()){
                    domainToByteArray[startNum_1++] = (byte) c;
                }
            }
            domainToByteArray[startNum_1++] = 0x00;
        }
        for(int i=0;i<domainToByteArray.length;i++){
            data [startNum++] = domainToByteArray[i];
        }
        byte[] temp_1 = tool.toByte ( dq.getqType () );
        for(int i=0;i<2;i++){
            data [startNum++] = temp_1 [i];
        }
        temp_1 = tool.toByte ( dq.getqClass () );
        for(int i=0;i<2;i++){
            data [startNum++] = temp_1 [i];
        }
        return data;

    }
    public static byte[] toByte(short s){
        byte[] result = new byte[2];
        //由高位到低位
        result[0] = (byte)((s >> 8) & 0xFF);
        result[1] = (byte)(s & 0xFF);
        return result;

    }
    public static byte[] toByteArrayAn(dnsrr dnsResponAn){
        byte[] data = new byte[12+dnsResponAn.getrLength ()];
        int startNum = 0;
        byte[] temp_1 = new byte[2];
        byte[] temp_2 = new byte[4];

        tool.assignValue ( startNum,data,temp_1,dnsResponAn.getrName () );
        startNum+=2;
        tool.assignValue ( startNum,data,temp_1,dnsResponAn.getrType () );
        startNum+=2;
        tool.assignValue ( startNum,data,temp_1,dnsResponAn.getrClass () );
        startNum+=2;
        tool.assignValue (startNum,data,temp_2,dnsResponAn.getRttl ());
        startNum+=4;
        tool.assignValue (startNum,data,temp_2,dnsResponAn.getrLength ());
        startNum+=2;
        if(dnsResponAn.getrLength () ==4){
            temp_2 = tool.ipToByte (dnsResponAn.getrData () );
            for(int i = 0;i<4;i++){
                data[startNum++] = temp_2[i];

            }

        }


        return data;
    };
    public static byte[] toByteArrayNs(dnsrr dnsResponNs){
            byte[] data = tool.toByteArrayAn ( dnsResponNs );
            return data;

    }
    public static byte[] ipToByte(String ip){
        byte[] data = new byte[4];
        String[] ipSubString = ip.split ( "\\." );
        for(int i = 0;i<ipSubString.length;i++){
            int num = Integer.parseInt (ipSubString[i] );
            byte temp = 0;
            if(num>127){
                temp = (byte)(num-256);
            }
            else
                temp = (byte)num;
            data[i] = temp;
        }
        return data;
    }
    public static void assignValue(int startNum,byte[] data,byte[] temp, short value){
        temp = tool.toByte ( value );
        for(int i=0 ; i<2 ; i++)
            data[ startNum+i ] = temp[ i ];
    }
    public static void assignValue(int startNum,byte[] data,byte[] temp, int value){
        temp = tool.toByteInt ( value );
        for(int i=0 ; i<2 ; i++)
            data[ startNum+i ] = temp[ i ];
    }
    public static byte[] toByteInt(int value){
        byte[] result = new byte[4];
        result[0] = (byte)((value>>24)&0xFF);
        result[1] = (byte)((value>>24)&0xFF);
        result[2] = (byte)((value>>24)&0xFF);
        result[3] = (byte)((value>>24)&0xFF);
        return result;
    }
    public static byte[] intergrationAll(byte[] dnsResponByteH,byte[] dnsResponByteQ,byte[] dnsResponByteAn,byte[] dnsResponByteNs,String ip){
        byte[] data = new byte[dnsResponByteH.length+dnsResponByteAn.length+dnsResponByteQ.length+dnsResponByteNs.length];
        int startNum = 0;
        for(int i = 0;i<dnsResponByteH.length;i++){
            data[startNum++] = dnsResponByteH[i];
        }
        for(int i = 0;i<dnsResponByteQ.length;i++){
            data[startNum++] = dnsResponByteQ[i];
        }
        if(!ip.equals ( "0.0.0.0" )){
            for(int i = 0;i<dnsResponByteAn.length;i++){
                data[startNum++] = dnsResponByteAn[i];
            }
        }

        for(int i = 0;i<dnsResponByteNs.length;i++){
            data[startNum++] = dnsResponByteNs[i];
        }
        return data;

    }

//    public  static void main(String args[]){
//        byte[] b = {(byte) 0x03,(byte) 0x77,(byte) 0x77,(byte) 0x77,(byte) 0x06,(byte) 0x67,(byte) 0x67,(byte)0x67,(byte)0x67,(byte)0x67,(byte)0x67,(byte)0x03,(byte)0x63,(byte)0x6f,(byte)0x6d,(byte)0x00};
//        tool.getDomianName ( b,0, (byte) 0 );
//
//    }


}
