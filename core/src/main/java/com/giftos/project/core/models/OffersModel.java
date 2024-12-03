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
        adapters = {OffersModel.class, ComponentExporter.class},
        resourceType = OffersModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class OffersModel implements ComponentExporter {

    public static final String RESOURCE_TYPE = "giftos/components/offers";

    @ChildResource
    private List<Offer> offerList; // Keep the raw Resource list for flexibility

    /**
     * Retrieves the list of Offer objects adapted from child resources.
     *
     * @return List of Offer objects or an empty list if no offers are present.
     */
    public List<Offer> getOffers() {
       return offerList;
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }

    /**
     * Model class for individual offer items.
     */
    @Model(
            adaptables = Resource.class,
            defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
    public static class Offer {

        @ValueMapValue
        private String offerImage;

        @ValueMapValue
        private String offerTitle;

        @ValueMapValue
        private String offerDescription;

        public String getOfferImage() {
            return offerImage;
        }

        public String getOfferTitle() {
            return offerTitle;
        }

        public String getOfferDescription() {
            return offerDescription;
        }
    }
}
