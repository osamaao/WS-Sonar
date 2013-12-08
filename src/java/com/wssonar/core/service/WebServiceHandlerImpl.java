package com.wssonar.core.service;

import com.wssonar.core.model.WebService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Web service handler, manages web services that are monitored and provides a list 
 * of these web services to other classes
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class WebServiceHandlerImpl implements WebServiceHandler {
    
    private List<WebService> webServices;

    public WebServiceHandlerImpl() {
        webServices = new ArrayList<>();
        initMap();
    }
   
    private void initMap() {
        webServices.add(new WebService("80923480", "weather.gov/forecasts", 
                "http://www.weather.gov/forecasts/xml/DWMLgen/wsdl/ndfdXML.wsdl",
                "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php"));
    }

    @Override
    public List<WebService> getWebServices() {
        return Collections.unmodifiableList(webServices);
    }

}
