package com.wssonar.core.controller;

import com.wssonar.core.model.Metric;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Logger;

/**
 *  A DeQue storage implementation with a capped size of 1000 metrics
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class MetricStorageHandlerImpl implements MetricStorageHandler {
    
    private final int MAX_SIZE = 1000;
    private final static Logger LOGGER = Logger.getLogger(MetricStorageHandlerImpl.class.getName());
    
    private ConcurrentLinkedDeque<Metric> metrics;

    public MetricStorageHandlerImpl() {
        metrics = new ConcurrentLinkedDeque<>();
    }
    
    @Override
    public void persist(Metric metric) {
        LOGGER.info("Saving metrics: " + metric.toString());
        if (metrics.size() > MAX_SIZE) {
            LOGGER.info("Max capacity reached, value = " + metrics.size());
            metrics.pollLast();
        }
        metrics.add(metric);
    }
    
    public Metric poll() {
        return metrics.poll();
    }
    
    public boolean isEmpty() {
        return metrics.isEmpty();
    }
    
}
