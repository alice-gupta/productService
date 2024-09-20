package configurations;

import dtos.FakeStoreProductsDto;
import models.Category;
import models.Products;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    private Products convertFakeStoreProductToProducts(FakeStoreProductsDto fakeStoreProductsDto) {
        //convert fakestoreproductdto to product as product is class
        Products products = new Products();
        products.setId(fakeStoreProductsDto.getId());
        products.setTitle(fakeStoreProductsDto.getTitle());
        products.setPrice(fakeStoreProductsDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductsDto.getCategory());
        products.setCategory(category);

        return products;
    }

}
