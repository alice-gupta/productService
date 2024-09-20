package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductsDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
