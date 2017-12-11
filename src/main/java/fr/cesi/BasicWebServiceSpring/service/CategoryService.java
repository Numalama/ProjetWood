/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.service;

import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.repository.CategoryDAO;
import fr.cesi.BasicWebServiceSpring.repository.UserDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Numalama
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
  
}
