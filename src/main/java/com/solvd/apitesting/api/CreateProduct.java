package com.solvd.apitesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/products/add", methodType = HttpMethodType.POST)
@ResponseTemplatePath(path = "api/products/_create/rs.json")
@RequestTemplatePath(path = "api/products/_create/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class CreateProduct extends AbstractApiMethodV2 {

    public CreateProduct(int id) {
        replaceUrlPlaceholder("id", String.valueOf(id));
    }
}
