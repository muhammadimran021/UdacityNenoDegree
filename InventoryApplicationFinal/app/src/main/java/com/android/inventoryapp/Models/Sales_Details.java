package com.android.inventoryapp.Models;

public class Sales_Details {

    private String produtName;
    private int sQuantity;
    private int sPrice;
    private int sQuantityLeft;
    private int sid;

    public Sales_Details(String produtName, int sQuantity, int sPrice, int sid,int sQuantityLeft) {
        this.produtName = produtName;
        this.sQuantity = sQuantity;
        this.sPrice = sPrice;
        this.sid = sid;
        this.sQuantityLeft=sQuantityLeft;

    }

    public int getsQuantityLeft() {
        return sQuantityLeft;
    }

    public void setsQuantityLeft(int sQuantityLeft) {
        this.sQuantityLeft = sQuantityLeft;
    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName;
    }

    public int getsQuantity() {
        return sQuantity;
    }

    public void setsQuantity(int sQuantity) {
        this.sQuantity = sQuantity;
    }

    public int getsPrice() {
        return sPrice;
    }

    public void setsPrice(int sPrice) {
        this.sPrice = sPrice;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
