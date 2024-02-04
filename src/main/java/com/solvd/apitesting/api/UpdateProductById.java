package com.solvd.apitesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/products/_update/rq.json")
@ResponseTemplatePath(path = "api/products/_update/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateProductById extends AbstractApiMethodV2 {

    public UpdateProductById(int id) {
        replaceUrlPlaceholder("id", String.valueOf(id));
    }
}
