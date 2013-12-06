/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wssonar.core.controller;

/**
 *
 * @author Osama Abu-Obeid <osamaao@gmail.com>
 */
public class Loader {
    
    String status;
    
    public Loader() {
        status = "Loaded";
        System.out.println("=============================> " + status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
