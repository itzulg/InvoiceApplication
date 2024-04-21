package com.itzul.invoiceapplication.model;

public class Product {

    private int id;
    private String name;
    private float price;
    private static int lastId;

    
    public Product() {
        this.id = ++lastId; //el id comienza en 1
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return id +
        "\t" + name + 
        "\t" + price;

    }
    
    

    

}
