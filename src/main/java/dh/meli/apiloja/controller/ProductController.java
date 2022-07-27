package dh.meli.apiloja.controller;

import dh.meli.apiloja.dto.ProductDto;
import dh.meli.apiloja.model.Product;
import dh.meli.apiloja.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController<T> {

    @Autowired
    public ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);

        return new ResponseEntity<ProductDto>(new ProductDto(newProduct), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getProduct() {
        List<ProductDto> productDtoList = new ArrayList<>();

        productService.getProduct().forEach(product -> {
            productDtoList.add(new ProductDto((Product) product));
        });

        return new ResponseEntity<List<ProductDto>>(productDtoList, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
        Product product = productService.getProductById(id);

        return new ResponseEntity<ProductDto>(new ProductDto(product), HttpStatus.OK);
    }

    @PatchMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id, @RequestBody Map<String, T> data) {
        Product product = productService.updateProduct(id, data);

        return new ResponseEntity<ProductDto>(new ProductDto(product), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
