package com.example.akhilnigam.bigdocto;

/**
 * Created by Akhil_xonym on 10-01-2018.
 */


public class MyData {

    private int id;
    private String typ;
    private String name,image_link;

    public MyData(int id, String name, String typ, String image_link) {
        this.id = id;
        this.name = name;
        this.typ=typ;
        this.image_link = image_link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }



    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
}