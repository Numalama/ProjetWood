/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.repository;
import fr.cesi.BasicWebServiceSpring.entity.Buyer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Numalama
 */
public interface BuyerDAO extends  CrudRepository<Buyer, Long>{
    
    Buyer findByFirstName(String FirstName);
   
}
