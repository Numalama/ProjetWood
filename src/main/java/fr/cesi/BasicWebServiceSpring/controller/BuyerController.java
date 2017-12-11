/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.controller;

import fr.cesi.BasicWebServiceSpring.entity.Buyer;
import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.service.BuyerService;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import org.json.JSONException;
import org.json.JSONObject;
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
@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService serviceBuyer;

    @Context
    private HttpServletResponse servletResponse;

    private void allowCrossDomainAccess() {
        if (servletResponse != null) {
            servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/buyer", method = RequestMethod.POST, consumes = "application/json")
    public Buyer getBuyer(@RequestBody Buyer buyer) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException {

        allowCrossDomainAccess();

        return buyer;

    }

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public String postRegisterBuyer(@RequestBody User utilisateur) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException {
        allowCrossDomainAccess();

        JSONObject response = new JSONObject();

        try {

            //response.put("Success", serviceBuyer.creatBuyer(utilisateur));
        } catch (Exception e) {
            response.put("Error", e);
        }

        return response.toString();
    }
}
