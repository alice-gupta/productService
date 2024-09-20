package services;

import dtos.FakeStoreProductsDto;
import models.Category;
import models.Products;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements productService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Products getSingleProduct(Long productId) {
        //call fakestore to fetch the product with given id=http call
        FakeStoreProductsDto fakeStoreProductsDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductsDto.class
        );

       return convertFakeStoreProductToProducts(fakeStoreProductsDto);
    }

    private Products convertFakeStoreProductToProducts(FakeStoreProductsDto fakeStoreProductsDto) {
        Products products = new Products();
        products.setId(fakeStoreProductsDto.getId());
        products.setTitle(fakeStoreProductsDto.getTitle());
        products.setPrice(fakeStoreProductsDto.getPrice());

        Category category=new Category();
        category.setDescription(fakeStoreProductsDto.getCategory());
        products.setCategory(category);

        return products;
    }


    @Override
    public List<Products> getAllProducts() {
        FakeStoreProductsDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductsDto[].class
        );
        //convert ListofFakeStoreDto into List of Products
        List<Products> products = new ArrayList<>();
        for (FakeStoreProductsDto fakeStoreProductsDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductToProducts(fakeStoreProductsDto));
        }
        return products;
    }

    @Override
    public Products updateProduct(Long id, Products product) {
        //patch-partial update
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductsDto.class);
        HttpMessageConverterExtractor<FakeStoreProductsDto> responseExtractor =
                new HttpMessageConverterExtractor(FakeStoreProductsDto.class, restTemplate.getMessageConverters());

        FakeStoreProductsDto response= restTemplate.execute("https://fakestoreapi.com/products/"+ id,
                HttpMethod.PATCH, requestCallback, responseExtractor);

        return convertFakeStoreProductToProducts(response);
    }



    @Override
    public Products replaceProduct(Long id, Products product) {
        //put
        return null;
    }



    @Override
    public void deleteProduct(Long id) {

    }
}
