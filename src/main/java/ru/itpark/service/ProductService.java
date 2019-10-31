package ru.itpark.service;

import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;

import java.util.*;

public class ProductService {
    private final ProductRepository repository;
    private String repositoryName = "Основной репозиторий";

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
        if (id > 0) {
            repository.delete(id);
        }
    }

    public List<Product> searchByName(String name) {
        List<Product> results = new LinkedList<>(repository.getAll());
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("введите название");
        }
        for (Product p : results) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p.toString());
            }
        }
        return results;
    }

    public List<Product> displayByCategory(String category) {
        List<Product> results = new LinkedList<>(repository.getAll());
        if (category == null || category.equals("")) {
            throw new IllegalArgumentException("неверная категория");
        }
        System.out.println(category);
        for (Product p : results) {
            if (p.getProductCategory().equals(category)) {
                System.out.println(p.toString());
            }
        }
        return results;
    }

    public List<Product> getSortedByPriceAsc() {
        List<Product> results = new LinkedList<>(repository.getAll());
        Collections.sort(results, (p1, p2) -> p1.getPrice() - p2.getPrice());
        return results;
    }

    public List<Product> getSortedByPriceDesc() {
        List<Product> results = new LinkedList<>(repository.getAll());
        Collections.sort(results, (p1, p2) -> -(p1.getPrice() - p2.getPrice()));
        return results;
    }

    public List<Product> getSortedByRatingAsc() {
        List<Product> results = new LinkedList<Product>(repository.getAll());
        Collections.sort(results, (p1, p2) -> (int) (p1.getRating() - p2.getRating()));
        return results;
    }

    public List<Product> getSortedByName() {
        List<Product> results = new LinkedList<>(repository.getAll());
        Collections.sort(results, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return results;
    }

//    public List<Product> getSortedByPrice() {
//        return getSortedBy(new ProductByPriceComparator());
//    }
//
//    public List<Product> getSortedBy(Comparator<Product> comparator) {
//        //List<Product> results = new LinkedList<>(repository.getAll());
//        results.sort(comparator);
//        return results;
//    }

    public Collection<Product> display() {
        System.out.println(repository.getAll());
        return repository.getAll();
    }


    @Override
    public String toString() {
        return repositoryName;
    }


}
