package com.giftos.project.core.services.Impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.giftos.project.core.services.GetResourceResovler;

@Component(service = GiftosServiceUser.class)
public class GiftosServiceUser implements GetResourceResovler{

    @Reference
    ResourceResolverFactory resolverFactory;

    @Override
    public ResourceResolver getResourceResolver() {
        ResourceResolver resolver = null;
        Map<String,Object> props = new HashMap<>();
        props.put(ResourceResolverFactory.SUBSERVICE,"giftossubService");

        try {
            resolver = resolverFactory.getServiceResourceResolver(props);
        } catch (LoginException e) {
            e.printStackTrace();
        }

        return resolver;
    }

}
