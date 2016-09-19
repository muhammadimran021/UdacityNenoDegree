package com.android.inventoryapp.Models;

public class Products {
    private String produtName;
    private int pQuantity;
    private int pPrice;
    private int id;

    public Products(String produtName, int pQuantity, int pPrice, int id) {
        this.produtName = produtName;
        this.pQuantity = pQuantity;
        this.pPrice = pPrice;
        this.id = id;
    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
