package dh.meli.apiloja.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter @Setter
@Document(indexName = "store_db")
public class Product {
    @Id
    @Field(name = "id", type = FieldType.Long)
    private long id;

    @Field(name = "name", type = FieldType.Text)
    private String name;

    @Field(name = "category", type = FieldType.Text)
    private String category;

    @Field(name = "quantity", type = FieldType.Long)
    private long quantity;

    @Field(name = "price", type = FieldType.Double)
    private double price;

    @Field(name = "warehouse", type = FieldType.Text)
    private String warehouse;
}
