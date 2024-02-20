package com.solvd.apitesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.DELETE)
//@ResponseTemplatePath(path = "api/products/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteProductById extends AbstractApiMethodV2 {

    public DeleteProductById(int id) {
        super(null, "api.products/_delete/rs.json");
        replaceUrlPlaceholder("id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
