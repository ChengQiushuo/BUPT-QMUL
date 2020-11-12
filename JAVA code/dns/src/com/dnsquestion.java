package com;

public class dnsquestion {
    private String qdomianName;
    private short qType;
    private short qClass;
    public short getqType(){
        return this.qType;
    }

    public void setqType ( short qType ) {
        this.qType = qType;
    }

    public String getQdomianName () {
        return qdomianName;
    }

    public void setQdomianName ( String qdomianName ) {
        this.qdomianName = qdomianName;
    }

    public short getqClass () {
        return qClass;
    }

    public void setqClass ( short qClass ) {
        this.qClass = qClass;
    }
    public dnsquestion(){

    }
    public dnsquestion(String qdomianName,short qType,short qClass){
        this.qdomianName = qdomianName;
        this.qClass = qClass;
        this. qType = qType;
    }
}
