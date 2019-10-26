package ru.itpark.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;


@Getter
@Setter
public class Product<T> {
    private long id;
    private String name;
    private String fullName;
    private double rating;
    private String review;
    private String badge;
    private T feature;
    private String gallery;
//    private Collection<Photo> gallery;
//
//    class Photo {
//        Photo(String URL) {}
//    }

    private String description;
    private int price;
    private String productCategory; // возможно, лучше int

    public Product(long id, String name, String fullName, double rating,
                   String review, String badge, T feature,
                   String gallery, String description,
                   int price, String productCategory) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.rating = rating;
        this.review = review;
        this.badge = badge;
        this.feature = feature;
        this.gallery = gallery;
        this.description = description;
        this.price = price;
        this.productCategory = productCategory;
    }

    public void setCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void buy() {
    }

    public void compare() {
    }

    public void toFavorites() {

    }

    @Override
    public String toString() {
        return name + "\t" + price + " руб.";
    }
}
