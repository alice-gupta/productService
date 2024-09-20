package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Products extends BaseModel{
    private String title;
    private double price;
    private Category category;
}
