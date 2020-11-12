package entity;

public class RamenInfo {
    public int ramen = 0;
    public String[] dishName = new String[7];//extra's name
    public int[] extraCount =new int[]{0, 0, 0, 0, 0, 0, 0};//数目
    public double[] dishPrice = new double[7];
    public String[] ramenOrder = {null, null, null, null, null};
}
