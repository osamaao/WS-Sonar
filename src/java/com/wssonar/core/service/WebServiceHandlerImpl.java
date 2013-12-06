/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wssonar.core.service;

import java.util.Map;
import com.wssonar.core.model.WebService;
import java.util.Collections;
/**
 *
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
import java.util.HashMap;
public class WebServiceHandlerImpl implements WebServiceHandler {
    
    private Map<String, WebService> webServices;

    public WebServiceHandlerImpl() {
        webServices = new HashMap<>();
        initMap();
    }
    
    private void initMap() {
        webServices.put("80923480", new WebService("80923480", "weather.gov/forecasts", 
                "http://www.weather.gov/forecasts/xml/DWMLgen/wsdl/ndfdXML.wsdl",
                "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php"));
    }

    public Map<String, WebService> getWebServices() {
        return webServices;
    }

    public void setWebServices(Map<String, WebService> webServices) {
        this.webServices = webServices;
    }

    @Override
    public Map<String, WebService> webServiceIterable() {
        return Collections.unmodifiableMap(webServices);
    }
    
    
}
