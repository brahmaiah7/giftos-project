package com.giftos.project.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContactUsModel {

    @ValueMapValue
    private String footerTitle;

    @ValueMapValue
    private String address;

    @ValueMapValue
    private String mobileNumber;

    @ValueMapValue
    private String email;

    public String getFooterTitle() {
        return footerTitle;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}

