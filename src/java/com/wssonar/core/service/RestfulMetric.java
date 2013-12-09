/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wssonar.core.service;

import com.wssonar.core.controller.MetricStorageHandlerImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
@Path("metrics")
@RequestScoped
public class RestfulMetric {
    
    private static Logger logger = Logger.getLogger(RestfulMetric.class.getName());
    private MetricStorageHandlerImpl metricsStorageHandlerImpl;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestfulMetric
     */
    @Inject
    public RestfulMetric(MetricStorageHandlerImpl metricsStorageHandlerImpl) {
        this.metricsStorageHandlerImpl = metricsStorageHandlerImpl;
    }

    /**
     * Retrieves representation of an instance of soen6861.a2.ex2.service.RestfulMetric
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMetrics() {
        logger.log(Level.INFO, "getMetrics called");
        return "{JSON: " + metricsStorageHandlerImpl.poll() + "}";
    }

    /**
     * PUT method for updating or creating an instance of RestfulMetric
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
        logger.log(Level.INFO, "putXML called with input: " + content);
    }
}
