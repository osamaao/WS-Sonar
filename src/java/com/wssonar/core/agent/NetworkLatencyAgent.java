package com.wssonar.core.agent;

import com.wssonar.core.model.Metric;
import com.wssonar.core.model.WebService;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.telnet.TelnetClient;

/**
 * Measures the network latency when opening a TCP/IP socket with a target web
 * server
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class NetworkLatencyAgent {
    
    private final static Logger LOGGER = Logger.getLogger(NetworkLatencyAgent.class.getName());
    private WebService ws;
    // Network latency in millisecond
    private Metric<Long> latency;
    
    public NetworkLatencyAgent(WebService ws) {
        this.ws = ws;
        prepareMetric();
    }
    
    /**
     * Creates and initializes a Metric<Long> instance.
     */
    private void prepareMetric() {
        latency = new Metric<>();
        latency.setName("network_latency");
        latency.setSystem(ws.getName());
        latency.setComponent(null);
        latency.setCreatedOn(new Date());
    }
    
    /**
     * Actual method that measures the Network Latency for the specified web service
     * @param ws
     * @return 
     */
    public Metric<Long> measure() {
        TelnetClient telnet = new TelnetClient();
        long t1 = System.nanoTime();
        try {
            telnet.connect(ws.getSoapHost(), ws.getSoapPort());
            long t2 = System.nanoTime();
            long time = (t2 - t1)/1000000;
            latency.setValue(time);
            LOGGER.log(Level.INFO, 
                    String.format("TCP Socket Latency =[%d], web-service: %s",
                    time, ws.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            telnet.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return latency;
    }
    
}
