package com.giftos.project.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;


@Model(
        adaptables = Resource.class,
        adapters = {ProductDetailsModel.class, ComponentExporter.class},
        resourceType = ProductDetailsModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ProductDetailsModel implements ComponentExporter {

    public static final String RESOURCE_TYPE = "giftos/components/productdetails";

    @ChildResource(name = "productList")
    private List<Product> productResources;

    public List<Product> getProducts() {
        return productResources;
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }

    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class Product {

        @ValueMapValue(name = "productTitle")
        private String productTitle;

        @ValueMapValue(name = "productUpload")
        private String productImage;

        @ValueMapValue(name = "productPrice")
        private Double productPrice;

        @ValueMapValue(name = "altTxt")
        private String imageAltText;

        public String getProductTitle() {
            return productTitle;
        }

        public String getProductImage() {
            return productImage;
        }

        public Double getProductPrice() {
            return productPrice;
        }

        public String getImageAltText() {
            return imageAltText;
        }
    }
}
