package com.itheima.web;

public class Emp {
    private int id;
    private String name;

    public Emp(String name) {
        this.name = name;
    }
    public Emp() {
    }
    public Emp(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
