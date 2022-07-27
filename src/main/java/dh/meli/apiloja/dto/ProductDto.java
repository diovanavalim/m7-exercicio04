package dh.meli.apiloja.dto;

import dh.meli.apiloja.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String category;
    private long quantity;
    private double price;

    public ProductDto(Product product) {
        this.name = product.getName();
        this.category = product.getCategory();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
    }
}
