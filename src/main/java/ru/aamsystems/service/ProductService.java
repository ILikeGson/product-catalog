package ru.aamsystems.service;

import ru.aamsystems.model.Product;
import java.util.List;

public interface ProductService {
    Product insert(Product product);
    Product findByName(String name);
    Product findById (long id);
    void update(Product product, long id);
    void deleteById(long id);
}
