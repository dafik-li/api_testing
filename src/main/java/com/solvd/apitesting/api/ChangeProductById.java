package com.solvd.apitesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.PUT)
//@RequestTemplatePath(path = "api/products/_change/rq.json")
//@ResponseTemplatePath(path = "api/products/_change/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class ChangeProductById extends AbstractApiMethodV2 {

    public ChangeProductById(int id) {
        super("api.products/_change/rq.json", "api.products/_change/rs.json");
        replaceUrlPlaceholder("id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
