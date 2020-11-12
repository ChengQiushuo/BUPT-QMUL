package com;

public class dnsheader {

    private short ID;
    private short flag;
    private short qdCount;
    private short anCount;
    private short nsCount;
    private short arCount;
    public dnsheader(){

    }
    public dnsheader(short ID,short flag,short qdCount,short anCount,short nsCount,short arCount)
    {
        this.ID = ID;
        this.flag = flag;
        this.qdCount= qdCount;
        this.anCount = anCount;
        this.arCount = arCount;
    }
    public short getID(){
        return this.ID;
    }

    public void setID ( short ID ) {
        this.ID = ID;
    }

    public short getFlag(){
        return flag;
    }

    public void setFlag ( short flag ) {
        this.flag = flag;
    }

    public short getAnCount () {
        return anCount;
    }

    public void setAnCount ( short anCount ) {
        this.anCount = anCount;
    }

    public short getArCount () {
        return arCount;
    }

    public void setArCount ( short arCount ) {
        this.arCount = arCount;
    }

    public short getNsCount () {
        return nsCount;
    }

    public void setNsCount ( short nsCount ) {
        this.nsCount = nsCount;
    }

    public short getQdCount () {
        return qdCount;
    }

    public void setQdCount ( short qdCount ) {
        this.qdCount = qdCount;
    }
}

