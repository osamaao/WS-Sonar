package com.wssonar.core.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a Web Service
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class WebService {

    private String id;
    private String name;
    private String wsdlUri;
    private String soapAddress;

    public WebService() {
    }

    public WebService(String id, String name, String wsdlUri, String soapAddress) {
        this.id = id;
        this.name = name;
        this.wsdlUri = wsdlUri;
        this.soapAddress = soapAddress;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWsdlUri() {
        return wsdlUri;
    }

    public void setWsdlUri(String wsdlUri) {
        this.wsdlUri = wsdlUri;
    }

    public String getSoapAddress() {
        return soapAddress;
    }

    public void setSoapAddress(String soapAddress) {
        this.soapAddress = soapAddress;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.wsdlUri);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WebService other = (WebService) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.wsdlUri, other.wsdlUri)) {
            return false;
        }
        return true;
    }
    
    /**
     * @return host name of the SOAP URI
     */
    public String getSoapHost() {
        String soapHost = "";
        try {
            URL url = new URL(soapAddress);
            soapHost = url.getHost();
        } catch (MalformedURLException ex) {
            Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soapHost;
    }

    /**
     * @return port number of the SOAP URI
     */
    public int getSoapPort() {
        int soapPort = 80;
        try {
            URL url = new URL(soapAddress);
            soapPort = url.getPort();
        } catch (MalformedURLException ex) {
            Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soapPort == -1 ? 80 : soapPort;
    }

    @Override
    public String toString() {
        return "WebService{" + "id=" + id + ", name=" + name + ", wsdlUri=" + wsdlUri + ", soapAddress=" + soapAddress + '}';
    }
    
}
