/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.controller;

import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.http.Response;
import fr.cesi.BasicWebServiceSpring.http.SuccessResponse;
import fr.cesi.BasicWebServiceSpring.repository.UserDAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1797531
 */
@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/user/jwt")
public class UserJWTController extends AbstractController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Response> login(@RequestBody User login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = userDao.findByEmail(email);

        if (user == null) {
            throw new ServletException("User name not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder()
                .setSubject(email)
                .claim("roles", "user") // here we will put buyer/seller aswell
                .claim("user", user.getId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();

        return this.responseSuccess("token", jwtToken);
    }
}
