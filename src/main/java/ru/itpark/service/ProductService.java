package ru.itpark.service;

import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;

import java.util.*;

public class ProductService {

    private final ProductRepository repository;
    private int fromIndex = 0;
    private int maxIndex = 10;

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

    public void deleteProduct(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("неверное id, должен быть больше ноля");
        }
        repository.delete(id);
    }

    public List<Product> searchByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("введите название");
        }
        List<Product> results = new LinkedList<>(repository.getAll());
        if (results.size() > maxIndex) {
            results = results.subList(fromIndex, maxIndex);
        }
        List<Product> sortedResults = new ArrayList<>();
        for (Product p : results) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                sortedResults.add(p);
            }
        }
        return sortedResults;
    }

    public List<Product> displayByCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("неверная категория");
        }
        List<Product> results = new LinkedList<>(repository.getAll());
        if (results.size() > maxIndex) {
            results = results.subList(fromIndex, maxIndex);
        }
        List<Product> sortedResults = new ArrayList<>();
        for (Product p : results) {
            if (p.getProductCategory().equals(category)) {
                sortedResults.add(p);
            }
        }
        sortedResults.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        return sortedResults;
    }

    public List<Product> getSortedByPriceAsc() {
        List<Product> results = new LinkedList<>(repository.getAll());
        results.sort((p1, p2) -> p1.getPrice() - p2.getPrice());
        return results;
    }

    public List<Product> getSortedByPriceDesc() {
        List<Product> results = new LinkedList<>(repository.getAll());
        results.sort((p1, p2) -> -(p1.getPrice() - p2.getPrice()));
        return results;
    }

    public List<Product> getSortedByRatingAsc() {
        List<Product> results = new LinkedList<Product>(repository.getAll());
        results.sort((p1, p2) -> (int) (p1.getRating() - p2.getRating()));
        return results;
    }

    public List<Product> getSortedByName() {
        List<Product> results = new LinkedList<>(repository.getAll());
        if (results.size() > maxIndex) {
            results = results.subList(fromIndex, maxIndex);
        }
        results.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        return results;
    }

    public Collection<Product> displayAll() {
        return repository.getAll();
    }

}
