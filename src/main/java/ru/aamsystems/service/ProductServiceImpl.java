package ru.aamsystems.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aamsystems.exception.ProductNotFoundException;
import ru.aamsystems.model.Product;
import ru.aamsystems.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public Product insert(Product product) {
        return repository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(long id) {
        Optional<Product> product =  repository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new ProductNotFoundException(String.format("product with id '%s' not found", id));
    }

    @Override
    @Transactional(readOnly = true)
    public Product findByName(String name) {
        Optional<Product> product =  repository.findByName(name);
        if (product.isPresent()) {
            return product.get();
        }
        throw new ProductNotFoundException(String.format("product with name '%s' not found", name));
    }

    @Override
    @Transactional
    public void update(Product product, long id) {
        repository.updateById(product.getName(), product.getInfo(), id);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
