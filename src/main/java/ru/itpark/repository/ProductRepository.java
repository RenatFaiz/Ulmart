package ru.itpark.repository;

import ru.itpark.model.Product;

import java.util.Collection;
import java.util.LinkedList;


public class ProductRepository<T> {


    private final Collection<Product> products = new LinkedList<>();
    private long nextId = 1;


    public void create(Product item) {
        if (item.getId() == 0) {
            item.setId(nextId++);
        }
        products.add(item);
    }

    public String read() {
        //if (id.equals(id.getId()))
        return products.toString();
    }

    public void delete(Product item) {
        item.getId();
        // products.removeIf();
    }

    public Collection<Product> getAll() {
        return products;
    }
}
