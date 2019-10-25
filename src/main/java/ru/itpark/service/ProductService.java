package ru.itpark.service;

import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product item) {
        if (item.getId() != 0) {
            throw new IllegalArgumentException("id должен быть ноль");
        }
        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше ноля");
        }
        repository.create(item);
    }

    public void deleteProduct(Product item) {
        repository.delete(item);
    }
    public List<Product> getSortedBy(Comparator<Product> comparator) {
        List<Product> results = new LinkedList<>(repository.getAll());
        results.sort(comparator);
        return results;
    }

}



//    public List<Product> searchByName(Product item) {
//        List<Product> results = new ArrayList<Product>();
//        return results;
//    }
//    public List<Product> displayByCategory(Product item) {
//        List<Product> category = new ArrayList<>();
//        return category;
//    }
