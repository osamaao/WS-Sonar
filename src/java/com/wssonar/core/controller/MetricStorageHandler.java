package com.wssonar.core.controller;

import com.wssonar.core.model.Metric;

/**
 * Defines how to store a {@link Metric}
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public interface MetricStorageHandler {
    
    public void persist(Metric metric);
    
}
