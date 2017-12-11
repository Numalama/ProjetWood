/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import org.json.JSONException;
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
public class AccountController {



    private SecureRandom random = new SecureRandom();

    @Context
    private HttpServletResponse servletResponse;

    private void allowCrossDomainAccess() {
        if (servletResponse != null) {
            servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/account", method = RequestMethod.POST, consumes = "application/json")
    public String getAccount(@RequestBody String jsonMessage) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {

        allowCrossDomainAccess();
       
        return "Account";

    }

}
