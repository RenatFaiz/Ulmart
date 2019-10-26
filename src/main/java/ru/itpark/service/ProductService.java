package ru.itpark.service;

import ru.itpark.comparator.ProductByPriceComparator;
import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;

import java.util.*;

public class ProductService {
    private final ProductRepository repository;
    private String reponame = "Основной репозиторий";

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

    public List<Product> getSortedByPrice() {
        return getSortedBy(new ProductByPriceComparator());
    }

    public List<Product> getSortedBy(Comparator<Product> comparator) {
        List<Product> results = new LinkedList<>(repository.getAll());
        results.sort(comparator);
        return results;
    }
    public Collection<Product> display() {
        System.out.println(repository.getAll());
        return repository.getAll();
    }

    @Override
    public String toString() {
        return reponame;
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
