package services;

import models.Products;

import java.util.List;


public interface productService {
    Products getSingleProduct(Long id);
    List<Products> getAllProducts();

    Products updateProduct(Long id,Products product);
    Products replaceProduct(Long id,Products product);

    void deleteProduct(Long id);
}
