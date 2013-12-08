package com.wssonar.core.service;

import com.wssonar.core.model.WebService;
import java.util.List;

/**
 * Classes implementing this interface provides
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public interface WebServiceHandler {
    
    public List<WebService> getWebServices();
    
}
