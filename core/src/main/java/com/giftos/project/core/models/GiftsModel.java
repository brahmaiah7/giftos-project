package com.giftos.project.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class GiftsModel {

    @ValueMapValue
    private String giftTitle;

    @ValueMapValue
    private String giftDescription;

    @ValueMapValue
    private String backgroundImage;

    @ValueMapValue
    private boolean gifts;

    // Getters for the fields

    public boolean isGifts() {
        return gifts;
    }

    public String getGiftTitle() {
        return giftTitle;
    }

    public String getGiftDescription() {
        return giftDescription;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }
}
