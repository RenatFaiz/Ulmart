package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
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
    private String description;
    private int price;
    private String productCategory;

    @Override
    public String toString() {
        return "Арт." + id + "\t" + name + "\t" + price + " руб.\n";
    }
}
