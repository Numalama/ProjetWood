/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.controller;

import fr.cesi.BasicWebServiceSpring.entity.Address;
import fr.cesi.BasicWebServiceSpring.service.AddressService;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Numalama
 */
@RestController
public class AddressController {

    @Autowired
    private AddressService serviceAddress;

    @Context
    private HttpServletResponse servletResponse;

    private void allowCrossDomainAccess() {
        if (servletResponse != null) {
            servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/address", method = RequestMethod.POST, consumes = "application/json")
    public Address getAddress(@RequestBody Address address) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException {
       
        allowCrossDomainAccess();
       
        return address;
                
        

    }
}
