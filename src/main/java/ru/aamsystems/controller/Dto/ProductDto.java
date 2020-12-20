package ru.aamsystems.controller.Dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.aamsystems.model.Product;


@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private long id;
    private String name;
    private String info;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static Product toDomainObject(ProductDto dto) {
        return new Product(dto.getId(), dto.getName(), dto.getInfo());
    }

    public static ProductDto toDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getInfo());
    }

}
