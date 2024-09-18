package controllers;

import models.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
   // https://localhost:8080/products/id
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Products getProductById(@PathVariable("id") Long id) {
        return null;
    }
    public List<Products> getAllProducts(){
        return new ArrayList<>();
    }

}
