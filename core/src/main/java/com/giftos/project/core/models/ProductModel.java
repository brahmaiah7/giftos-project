package com.giftos.project.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(
    adaptables = Resource.class,
        defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL
    )
public class ProductModel {

    @ValueMapValue
    private String productTitle;

    @ValueMapValue
    private String productUpload;

    @ValueMapValue
    private Double productPrice;

    @ValueMapValue
    private String altText;

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductUpload() {
        return productUpload;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getAltText() {
        return altText;
    }

    @PostConstruct
    void init()
    {
        System.out.println();
    }
}
