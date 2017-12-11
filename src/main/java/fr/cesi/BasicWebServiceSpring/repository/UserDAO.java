/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.repository;

import fr.cesi.BasicWebServiceSpring.entity.User;
import java.util.List;
import static org.json.XMLTokener.entity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Numalama
 */
public interface UserDAO extends CrudRepository<User, Long> {

    User findById(int id);
    
    //User findByNickname(String Nickname);
    User findByFirstName(String FirstName);
   // boolean existsByNickname(String Nickname);
    boolean existsByFirstName(String FirstName);
    User findByEmail(String Email);

   // boolean existsByNicknameAndPassword(String Nickname, String password);
    boolean existsByFirstNameAndPassword(String FirstName, String password);
    
    // for register direct go to the dao 
    User save(User user);

}
