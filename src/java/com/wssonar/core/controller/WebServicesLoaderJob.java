package com.wssonar.core.controller;

import com.wssonar.core.service.WebServiceHandler;
import javax.inject.Inject;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Loads web services data to be used by the WebServiceHandler
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class WebServicesLoaderJob {
    
    private WebServiceHandler wsHandler;

    @Inject
    public WebServicesLoaderJob(WebServiceHandler wsHandler) {
        this.wsHandler = wsHandler;
    }
    
    @Scheduled(fixedDelay = 300000)
    public void perform() {
        System.out.println(
                "============>" +
                Thread.currentThread().getId() + "-" + 
                Thread.currentThread().getName() + 
                " MetricCollectorJob called...");
    }
    
    protected void getSocketTimeToOpen(String uri) {
        
    }
}
