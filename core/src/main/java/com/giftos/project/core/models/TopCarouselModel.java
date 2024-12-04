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
    adapters = { TopCarouselModel.class, ComponentExporter.class },
    resourceType = TopCarouselModel.RESOURCE_TYPE, // Replace with your component's resource type
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TopCarouselModel implements ComponentExporter {

    public static final String RESOURCE_TYPE = "giftos/components/topcarousel";

    // Inject the child resources representing the list of carousel items
    @ChildResource(name = "topList")
    private List<TopCarouselItemModel> topList;

    // Getter for the list of carousel items
    public List<TopCarouselItemModel> getTopList() {
        return topList;
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }

    /**
     * Inner class to map the individual carousel items
     */
    @Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
    public static class TopCarouselItemModel {

        @ValueMapValue
        private String image;

        @ValueMapValue
        private String shopDescription;

        // Getter for image path
        public String getImage() {
            return image;
        }

        // Getter for shop description
        public String getShopDescription() {
            return shopDescription;
        }
    }
}
