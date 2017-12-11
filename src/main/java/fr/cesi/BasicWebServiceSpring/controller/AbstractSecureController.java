/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.controller;

import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.service.UserService;
import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Valentin Lafranca
 */
public abstract class AbstractSecureController extends AbstractController {
    
    protected User user;
    
    @Autowired
    private UserService userService;
    
    /**
     * Retrieve the authenticated user. (cache)
     * The user is retrieved from db only first time and is cached.
     * @return User
     */
    public User getUser(){
        return this.getUser(false);
    }
 
    /**
     * Retrieve the authenticated user. (no cache)
     * The user is retrieved from db and not from cache.
     * @return User
     */
    public User getUser(boolean refresh){
        if(this.user == null || refresh){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Claims claims = (Claims) request.getAttribute("claims");
            int userId = claims.get("user", Integer.class);

            this.user = userService.findById(userId);
        }
        
        return this.user;
    }
    
    
}
