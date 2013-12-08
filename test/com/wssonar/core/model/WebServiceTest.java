package com.wssonar.core.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for class {@link WebService}
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class WebServiceTest {
    
    private WebService ws;
    
    public WebServiceTest() {
    }
    
    @Before
    public void setUp() {
        ws = new WebService();
        ws.setId("098123");
        ws.setName("XYZ web service");
        ws.setSoapAddress("http://www.xyz.com:8080/test1/param1/param2?arg1=1233");
        ws.setWsdlUri("http://www.xyz.com:8080?wsdl");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class WebService.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = "098123";
        String result = ws.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class WebService.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "938475";
        ws.setId(id);
        String result = ws.getId();
        assertEquals(id, result);
    }

    /**
     * Test of getName method, of class WebService.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "XYZ web service";
        String result = ws.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class WebService.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "IJK";
        ws.setName(name);
        String result = ws.getName();
        assertEquals(name, result);
    }

    /**
     * Test of getWsdlUri method, of class WebService.
     */
    @Test
    public void testGetWsdlUri() {
        System.out.println("getWsdlUri");
        String expResult = "http://www.xyz.com:8080?wsdl";
        String result = ws.getWsdlUri();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWsdlUri method, of class WebService.
     */
    @Test
    public void testSetWsdlUri() {
        System.out.println("setWsdlUri");
        String wsdlUri = "http://www.abc.com/?wsdl";
        ws.setWsdlUri(wsdlUri);
        String result = ws.getWsdlUri();
        assertEquals(wsdlUri, result);
    }

    /**
     * Test of getSoapAddress method, of class WebService.
     */
    @Test
    public void testGetSoapAddress() {
        System.out.println("getSoapHost");
        String expResult = "http://www.xyz.com:8080/test1/param1/param2?arg1=1233";
        String result = ws.getSoapAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSoapAddress method, of class WebService.
     */
    @Test
    public void testSetSoapAddress() {
        System.out.println("setSoapAddress");
        String soapAddress = "http://www.abc.com/?wsdl";
        ws.setSoapAddress(soapAddress);
        String result = ws.getSoapAddress();
        assertEquals(soapAddress, result);
    }

    /**
     * Test of equals method, of class WebService.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new WebService("098123", "XYZ web service", 
                "http://www.xyz.com:8080?wsdl", 
                "http://www.xyz.com:8080/test1/param1/param2?arg1=1233");
        boolean expResult = true;
        boolean result = ws.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSoapHost method, of class WebService.
     */
    @Test
    public void testGetSoapHost() {
        String expREsult = "www.xyz.com";
        String result = ws.getSoapHost();
        assertEquals(expREsult, result);
    }

    /**
     * Test of getSoapHost method, of class WebService.
     */
    @Test
    public void testGetSoapHostWithPort() {
        ws.setSoapAddress("http://www1.xyz.com:1234/abc/ijk?test=true");
        String expREsult = "www1.xyz.com";
        String result = ws.getSoapHost();
        assertEquals(expREsult, result);
    }

    /**
     * Test of getSoapPort method, of class WebService.
     */
    @Test
    public void testGetSoapDefaultPort() {
        ws.setSoapAddress("http://xyz.com/test?value=009");
        int expREsult = 80;
        int result = ws.getSoapPort();
        assertEquals(expREsult, result);
    }

    /**
     * Test of getSoapPort method, of class WebService.
     */
    @Test
    public void testGetSoapDifferentPort() {
        ws.setSoapAddress("http://www1.abc.com:8080/test=no");
        int expREsult = 8080;
        int result = ws.getSoapPort();
        assertEquals(expREsult, result);
    }

}