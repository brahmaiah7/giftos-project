package com.giftos.project.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ClientDetailsModel {

    @ChildResource
    private List<CarouselItem> clientList;

    public List<CarouselItem> getClientList() {
        return clientList;
    }

    @Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
    public static class CarouselItem {

        @ValueMapValue
        private String clientName;

        @ValueMapValue
        private String clientTitle;

        @ValueMapValue
        private String clientDescription;

        public String getClientName() {
            return clientName;
        }

        public String getClientTitle() {
            return clientTitle;
        }

        public String getClientDescription() {
            return clientDescription;
        }
    }
}
