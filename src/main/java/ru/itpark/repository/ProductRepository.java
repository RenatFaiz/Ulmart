package ru.itpark.repository;

import ru.itpark.model.Product;

import java.util.Collection;
import java.util.LinkedList;

public class ProductRepository {
    private final Collection<Product> products = new LinkedList<>();
    private long nextId = 1;
    private int productCategory;

    public void setCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public void addProduct(Product item) {
        if (item.getId() == 0) {
            item.setId(nextId++);
        }
        products.add(item);
    }
    public Collection<Product> getAll() {
        return products;
    }
}
