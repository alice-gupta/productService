package services;

import models.Products;

import java.util.List;


public interface ProductService {
    Products getSingleProduct(Long id);
    List<Products> getAllProducts();
}
