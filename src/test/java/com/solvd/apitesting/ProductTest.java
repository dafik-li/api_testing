package com.solvd.apitesting;

import com.solvd.apitesting.api.*;
import com.solvd.apitesting.domain.Product;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public class ProductTest {

    @Test(description = "verify POST method", dataProvider = "product")
    public void verifyCreateProductTest(Product product) {
        CreateProduct api = new CreateProduct();
        api.addProperty("product", product);

        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(description = "verify GET method", dataProvider = "product")
    public void verifyGetProductTest(Product product) {
        GetProductById api = new GetProductById(product.getId());
        api.addProperty("product", product);

        api.callAPIExpectSuccess();
        api.validateResponse(idPredicate(product));
    }

    @Test(description = "verify DELETE method", dataProvider = "product")
    public void verifyDeleteProductTest(Product product) {
        DeleteProductById api = new DeleteProductById(product.getId());
        api.addProperty("product", product);

        api.callAPIExpectSuccess();

        JsonComparatorContext comparatorContext = idPredicate(product)
                .<String>withPredicate("datePredicate", date -> isDateValid(date)
                        && ZonedDateTime.parse(date).isAfter(LocalDate.of(2024, 2, 4)
                        .atStartOfDay(ZoneId.systemDefault())));

        api.validateResponse(comparatorContext);
    }

    @Test(description = "verify PATCH method", dataProvider = "product")
    public void verifyUpdateProductTest(Product product) {
        UpdateProductById api = new UpdateProductById(product.getId());
        product.setPrice(550);
        api.addProperty("product", product);

        api.callAPIExpectSuccess();
        api.validateResponse(idPredicate(product));
    }

    @Test(description = "verify PUT method", dataProvider = "product")
    public void verifyChangeProductTest(Product product) {
        ChangeProductById api = new ChangeProductById(product.getId());
        product.setRating(8.0);
        api.addProperty("product", product);

        api.callAPIExpectSuccess();
        api.validateResponse(idPredicate(product));
    }

    private static boolean isDateValid(String date) {
        try {
            ZonedDateTime.parse(date);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    private JsonComparatorContext idPredicate(Product product) {
        return JsonComparatorContext.context()
                .<Integer>withPredicate("idPredicate", id -> Objects.equals(id, product.getId()));
    }

    @DataProvider(name = "product")
    public Object[][] product() {
        return new Object[][]{
                {
                        new Product(
                                1,
                                "iPhone 9",
                                "An apple mobile which is nothing like apple",
                                549,
                                12.96,
                                4.69,
                                94,
                                "Apple",
                                "smartphones")
                }
        };
    }
}
