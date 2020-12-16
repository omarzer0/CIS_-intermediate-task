package com.azapps.cis_intermediate_task.pojo;

public class FoodItem {
    public static final String CURRENCY = " EGP";
    private int imgRes;
    private boolean hasOfferPrice;
    private String name;
    private double price;
    private double offerPrice;
    private double rating;

    public FoodItem(int imgRes, String name, double price, double offerPrice, double rating, boolean hasOfferPrice) {
        this.imgRes = imgRes;
        this.name = name;
        this.price = price;
        this.offerPrice = offerPrice;
        this.rating = rating;
        this.hasOfferPrice = hasOfferPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price + CURRENCY;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOfferPrice() {
        return offerPrice + CURRENCY;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isHasOfferPrice() {
        return hasOfferPrice;
    }

    public void setHasOfferPrice(boolean hasOfferPrice) {
        this.hasOfferPrice = hasOfferPrice;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
