package com.example.learning;


public class Apple {
    private String name;
    private String color;

    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Apple() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
