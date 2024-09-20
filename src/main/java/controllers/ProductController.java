package controllers;

import models.Products;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
   // https://localhost:8080/products/id
    private services.productService productService;

    public ProductController(services.productService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Products getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    @GetMapping
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
    }

    public void deleteProduct(Long productId){

    }

    //patch->http://localhost:8080/products/1
    @PatchMapping("/{id}")
    public Products updateProduct(@PathVariable("id") Long id,@RequestBody Products product){
            return null;
    }

    @PutMapping("/{id}")
    public Products replaceProduct(@PathVariable("id") Long productId, @RequestBody Products product){
           return null;
    }



}
