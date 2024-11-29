package com.giftos.project.core.models;


import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;



@Model(
        adaptables = Resource.class)
public class NavigationBarModel  {

    public static class NavLink {
        private final String title;
        private final String path;

        public NavLink(String title, String path) {
            this.title = title;
            this.path = path;
        }

        public String getTitle() {
            return title;
        }

        public String getPath() {
            return path;
        }
    }

    @ChildResource(name = "navLinks")
    private List<Resource> navLinksResources;

    
    public List<NavLink> getNavLinks() {
        List<NavLink> navLinks = new ArrayList<>();
        if (navLinksResources != null) {
            for (Resource resource : navLinksResources) {
                String title = resource.getValueMap().get("linkTitle", String.class);
                String path = resource.getValueMap().get("linkPath", String.class);
                if (title != null && path != null) {
                    navLinks.add(new NavLink(title, path));
                }
            }
        }
        return navLinks;
    }
}