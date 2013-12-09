package com.wssonar.core.controller;

import com.wssonar.core.agent.NetworkLatencyAgent;
import com.wssonar.core.service.WebServiceHandler;
import com.wssonar.core.model.WebService;
import com.wssonar.core.model.Metric;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Job runs periodically to collect metrics of web services provided by the
 * {@link WebServicesLoaderJob}
 *
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class MetricCollectorJob {

    private WebServiceHandler wsHandler;
    private MetricStorageHandler metricsStorageHandlerImpl;
    private final static Logger LOGGER = Logger.getLogger(MetricCollectorJob.class.getName());

    @Inject
    public MetricCollectorJob(WebServiceHandler wsHandler, MetricStorageHandlerImpl metricsStorageHandlerImpl) {
        this.wsHandler = wsHandler;
        this.metricsStorageHandlerImpl = metricsStorageHandlerImpl;
    }

    @Scheduled(fixedDelay = 5000)
    public void perform() {
        LOGGER.log(Level.INFO, "{0} MetricCollectorJob called...", Thread.currentThread().toString());
        List<WebService> webServices = wsHandler.getWebServices();
        for (WebService ws: webServices) {
            NetworkLatencyAgent latencyAgent = new NetworkLatencyAgent(ws);
            Metric<Long> latency = latencyAgent.measure();
            metricsStorageHandlerImpl.persist(latency);
        }
    }

    protected void getSocketTimeToOpen(String uri) {
    }
}
