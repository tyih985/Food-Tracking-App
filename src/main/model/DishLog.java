package model;

import exceptions.*;

// DishLog represents a log of a dish a user has had.
// In each DishLog, the user records the name of the dish, the restaurant the dish came from, the price of the dish,
// the level of enjoyment they experienced from the dish (on a scale from 1-5), and if the dish is a favourite.
public class DishLog {
    private String name;
    private String restaurant;
    private double price;
    private int enjoymentLevel;
    private boolean favourite;

    // REQUIRES: name.length() > 0, restaurant.length() > 0, price >= 0, enjoymentLevel in [1, 5]
    // EFFECTS: Makes new DishLog with given name, restaurant, price, enjoymentLevel, and favourite status
    public DishLog(String name, String restaurant, double price, int enjoymentLevel, boolean favourite) {
        this.name = name;
        this.restaurant = restaurant;
        this.price = price;
        this.enjoymentLevel = enjoymentLevel;
        this.favourite = favourite;
    }

    public String getName() {
        return this.name;
    }

    public String getRestaurant() {
        return this.restaurant;
    }

    public double getPrice() {
        return this.price;
    }

    public int getEnjoymentLevel() {
        return this.enjoymentLevel;
    }

    public boolean getFavourite() {
        return this.favourite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEnjoymentLevel(int enjoymentLevel) {
        this.enjoymentLevel = enjoymentLevel;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
