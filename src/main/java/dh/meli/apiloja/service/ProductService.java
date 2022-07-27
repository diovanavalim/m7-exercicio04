package dh.meli.apiloja.service;

import dh.meli.apiloja.exception.*;
import dh.meli.apiloja.model.Product;
import dh.meli.apiloja.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService<T> {

    @Autowired
    public ProductRepository productRepository;

    public Product createProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new SaveException(e.getMessage());
        }
    }

    public List<Product> getProduct() {
        try {
            List<Product> productList = new ArrayList<Product>();

            productRepository.findAll().forEach(productList::add);

            return productList;
        } catch (Exception e) {
            throw new GetException(e.getMessage());
        }
    }

    public Product getProductById(long id) {
        Optional<Product> product;

        try {
            product = productRepository.findById(id);
        } catch (Exception e) {
            throw new GetException(e.getMessage());
        }

        if (product.isEmpty()) {
            throw  new ProductNotFoundException(String.format("Could not find product for id %d", id));
        }

        return product.get();
    }

    public Product updateProduct(long id, Map<String, T> data) {
        Product product = this.getProductById(id);

        data.forEach((attr, value) -> {
            switch (attr) {
                case "name": product.setName((String) value); break;
                case "category": product.setCategory((String) value); break;
                case "quantity": product.setQuantity(Long.valueOf((int) value)); break;
                case "price": product.setPrice((double) value); break;
                case "warehouse": product.setWarehouse((String) value); break;
            }
        });

        try {
            productRepository.save(product);
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }

        return product;
    }

    public void deleteProduct(long id) {
        Product product = this.getProductById(id);

        try {
            productRepository.delete(product);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
}
