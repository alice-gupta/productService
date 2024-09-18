package services;

import models.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Products getSingleProduct(Long id) {
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }
}
