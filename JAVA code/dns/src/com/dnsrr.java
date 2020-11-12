package com;

public class dnsrr {
    private short rName;
    private short rType;
    private short rClass;
    private int rttl;
    private short rLength;
    private String rData;
    public dnsrr(short rName,short rType,short rClass,int rttl,short rLength,String rData){
        this.rName = rName;
        this.rClass = rClass;
        this.rttl = rttl;
        this.rLength = rLength;
        this.rData = rData;
        this.rType = rType;
    }
    public dnsrr(){

    }

    public short getrName () {
        return rName;
    }

    public void setrName ( short rName ) {
        this.rName = rName;
    }

    public short getrType () {
        return rType;
    }

    public void setrType ( short rType ) {
        this.rType = rType;
    }

    public short getrClass () {
        return rClass;
    }

    public void setrClass ( short rClass ) {
        this.rClass = rClass;
    }

    public int getRttl () {
        return rttl;
    }

    public void setRttl ( int rttl ) {
        this.rttl = rttl;
    }

    public short getrLength () {
        return rLength;
    }

    public void setrData ( String rData ) {
        this.rData = rData;
    }

    public void setrLength ( short rLength ) {
        this.rLength = rLength;
    }

    public String getrData () {
        return rData;
    }
}
