package ru.itpark.comparator;


import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProductByCategory {
    private Product product;
    private ProductRepository repository;

    public boolean compare(String fromUser) {
        if (product.getProductCategory().equals(fromUser)) {
            return true;
        }
        return false;
    }



}
