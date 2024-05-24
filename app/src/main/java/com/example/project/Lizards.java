package com.example.project;

public class Lizards {
    private String name;
    private String location;
    private String category;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Lizards(String name, String location, String category, int cost) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.cost = cost;
    }
}