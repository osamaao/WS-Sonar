package com.wssonar.core.service;

import com.wssonar.core.model.WebService;
import java.util.Map;

/**
 *
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public interface WebServiceHandler {
    
    public Map<String, WebService> webServiceIterable();
    
}
