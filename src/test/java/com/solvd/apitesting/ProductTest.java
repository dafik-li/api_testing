package com.solvd.apitesting;

import com.solvd.apitesting.api.GetProductById;
import com.solvd.apitesting.domain.Product;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class ProductTest {

    @Test
    public void verifyCreateProductTest() {

    }

    @Test
    public void verifyGetProductTest() {
        Product product = new Product();
        product.setId(1);

        GetProductById api = new GetProductById(product.getId());
        api.addProperty("product", product);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
    }

    @Test
    public void verifyDeleteProductTest() {

    }

    @Test
    public void verifyUpdateProductTest() {

    }

    @Test
    public void verifyChangeProductTest() {

    }
}
