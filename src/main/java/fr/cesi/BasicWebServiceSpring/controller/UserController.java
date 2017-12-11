/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.controller;

import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.service.UserService;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Numalama
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService serviceUser;

    @Context
    private HttpServletResponse servletResponse;

    private void allowCrossDomainAccess() {
        if (servletResponse != null) {
            servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public String getLogin(@RequestBody User utilisateur) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException {

        allowCrossDomainAccess();
        
        JSONObject response = new JSONObject();
        if (serviceUser.userExist(utilisateur)) {
            response.put("Success", "Authentification Ok");
        } else {
            response.put("Error", "Authentification Failed");
           
        }
        return response.toString();
    }

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public String postRegister(@RequestBody User utilisateur) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException {
        allowCrossDomainAccess();

        JSONObject response = new JSONObject();

        try {
            if(!serviceUser.userExistByNickname(utilisateur)){
            response.put("Success", serviceUser.creatUser(utilisateur));
        }else{
                response.put("Error", "Un utilisateur possède déjà ce nickname man");
            }
            
        } catch (Exception e) {
            response.put("Error", e);
        }

        return response.toString();
    }

    @CrossOrigin
    @RequestMapping(value = "/get/by/nickname/{nickname}", method = RequestMethod.GET, consumes = "application/json")
    public User getUserById(@PathVariable String firstname) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException {
        allowCrossDomainAccess();

        return serviceUser.getUserByFirstName(firstname);

    }

    @CrossOrigin
    @RequestMapping(value = "/get/by/email/{email}", method = RequestMethod.GET, consumes = "application/json")
    public User getUserByEmail(@PathVariable String email) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException {
        allowCrossDomainAccess();

        return serviceUser.getUserByEmail(email);

    }

   
}
