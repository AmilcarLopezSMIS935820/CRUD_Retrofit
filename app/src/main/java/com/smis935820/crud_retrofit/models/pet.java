
package com.smis935820.crud_retrofit.models;

public class pet {
    private Integer id;
    private String name;
    private String age;
    private String color;
    private String created_at;


    //constructor vacio
    public pet(){}

    //Constructor
    public pet(String name, String age, String color, String created_at) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.created_at = created_at;
    }

    //Getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
