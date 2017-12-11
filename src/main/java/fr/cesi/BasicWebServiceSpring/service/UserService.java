/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.service;

import fr.cesi.BasicWebServiceSpring.entity.Address;
import fr.cesi.BasicWebServiceSpring.entity.Phones;
import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.repository.UserDAO;
import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Numalama
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User findById(int id){
        return userDAO.findById(id);
    }
    
    public User saveUserChanges(User utilisateur) {

        User user = this.userDAO.findById(utilisateur.getId());
        userDAO.save(user);
        System.out.println("sauvegarde ok");
        return user;

    }

    public Boolean userExist(User utilisateur) {

        return this.userDAO.existsByFirstNameAndPassword(utilisateur.getFirstName(), utilisateur.getPassword());
    }
    
    public Boolean userExistByNickname(User utilisateur) {

        return this.userDAO.existsByFirstName(utilisateur.getFirstName());
    }

    public User getUserProfile(User utilisateur) {

        User user = this.userDAO.findById(utilisateur.getId());
        return user;
    }

    public User getUserByFirstName(String firstName) {

        return this.userDAO.findByFirstName(firstName);

    }

    public User getUserByEmail(String email) {

        return this.userDAO.findByEmail(email);

    }

    public String creatUser(User utilisateur) {

        //Création d'un nouveau user
        User new_user = new User();
        new_user.setFirstName(utilisateur.getFirstName());
        new_user.setLastName(utilisateur.getLastName());
        new_user.setBirthDate(utilisateur.getBirthDate());
        new_user.setEmail(utilisateur.getEmail());
        new_user.setPassword(utilisateur.getPassword());

        //save du user en base de données afin de lui attribuer un id
        userDAO.save(new_user);

        // utilisateur en base de données avec id
        User user = this.userDAO.findByFirstName(utilisateur.getFirstName());

        // Adress à ajouter
        Set<Address> addresses_add = utilisateur.getAddresses();
        // liste d'adresses du user en base
        Set<Address> addresses = user.getAddresses();
        // Nouvelle objet adress à remplir
        Address address = new Address();
        // Ont boucle sur l'adresse à ajouter 
        // afin de remplir le nouvelle object adress
        Iterator<Address> iter_address = addresses_add.iterator();
        while (iter_address.hasNext()) {

            Address adress = iter_address.next();

            address.setLine1(adress.getLine1());
            address.setLine2(adress.getLine2());
            address.setLine3(adress.getLine3());
            address.setPostalCode(adress.getPostalCode());
            address.setCity(adress.getCity());
            address.setCountry(adress.getCountry());
            address.setLabel(adress.getLabel());
            address.setUser(user);
            // Ont push l'object adress remplis dans la liste d'adress du user
            addresses.add(address);
            // Ont met a jour la liste d'adresse
            user.setAddresses(addresses);

        }

        //pareille que pour adress mais avec phones
        // Ajoute un téléphone au user
        Set<Phones> phoneses_add = utilisateur.getPhoneses();
        Set<Phones> phoneses = user.getPhoneses();
        Phones phone = new Phones();

        Iterator<Phones> iter_phone = phoneses_add.iterator();
        while (iter_phone.hasNext()) {

            Phones phones = iter_phone.next();

            phone.setNumber(phones.getNumber());
            phone.setCountry(phones.getCountry());
            phone.setUser(user);
            phoneses.add(phone);
            user.setPhoneses(phoneses);

        }

        userDAO.save(user);

        return "Utilisateur creer avec succès";
    }

}
