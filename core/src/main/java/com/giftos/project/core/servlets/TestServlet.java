package com.giftos.project.core.servlets;

import java.io.IOException;


import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.giftos.project.core.services.Impl.GiftosServiceUser;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/giftos")
public class TestServlet extends SlingSafeMethodsServlet {

    @Reference
    GiftosServiceUser giftosServiceUser;

    private static final Logger LOG=LoggerFactory.getLogger(TestServlet.class);

    private static final String PAGE_PATH = "/content/giftos/us/en/index";

    @Override
    protected void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response)
            throws ServletException, IOException {
       ResourceResolver resolver= giftosServiceUser.getResourceResolver();
       
       PageManager pageManager = resolver.adaptTo(PageManager.class);

       Page page=pageManager.getPage(PAGE_PATH);

        LOG.info("Description:{}",page.getDescription());
        LOG.info("Title:{}",page.getTitle());
        LOG.info("Page Title:{}",page.getPageTitle());
        LOG.info("Name:{}",page.getName());
       response.getWriter().println("Log Message printed Check once in the logs");       
    }
    

}
