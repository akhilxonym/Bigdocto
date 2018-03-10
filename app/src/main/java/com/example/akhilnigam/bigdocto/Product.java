package com.example.akhilnigam.bigdocto;

/**
 * Created by Akhil_xonym on 13-01-2018.
 */
public class Product {
    private String image;
    private String name;
    private String price;
    private String Address;
    private String Time;

    public Product(String image, String name, String price,String Address,String Time) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.Address= Address;
        this.Time= Time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }


    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }


}