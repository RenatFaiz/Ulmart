package ru.itpark.service;

import ru.itpark.comparator.ProductByPriceComparator;
import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;

import java.util.*;

public class ProductService {
    private final ProductRepository repository;
    private String repositoryName = "Основной репозиторий";
    //List list = getList();  // инициализируйте этот список
    // Class<? extends ProductService> results = getClass();


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

    public List<Product> getSortedByName() {
        List<Product> results = new LinkedList<>(repository.getAll());
        Collections.sort(results, (Comparator<Product>) (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return results;
    }

    @Override
    public String toString() {
        return repositoryName;
    }

    public List<Product> searchByName(String name) {
        List<Product> results = new LinkedList<>(repository.getAll());
        if (name == null || name == "") {
            throw new IllegalArgumentException("введите название");
        }
        for (Product p : results) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p.toString());
            }
        }
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
