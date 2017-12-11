/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Numalama
 */
@Service
public class BuyerService {
    
}
/*
    @Autowired
    private BuyerDAO BuyerDAO;
    @Autowired
    private UserDAO userDAO;
 
    public String creatBuyer(User utilisateur) {
       
        //User current via dao
        User user = this.userDAO.findByNickname(utilisateur.getNickname());
        
        if(user){
            
        }
        //Création d'un nouveau buyer
        Buyer new_buyer = new Buyer();

        

        //pareille que pour adress mais avec phones
        // Ajoute un téléphone au user
        Set<Buyer> buyer_add = utilisateur.getBuyer();
        //Set<Buyer> buyers = buyer.getBuyers();

        Buyer buyer = new Buyer();

        Iterator<Buyer> iter_Buyer = buyer_add.iterator();
        while (iter_Buyer.hasNext()) {

            Buyer buyer_buyer = iter_Buyer.next();

            //phone.setNumber(seller_seller.getNumber());
            //phone.setCountry(seller_seller.getCountry());
            //phone.setUser(user);
            //buyer.setUser(user);
            buyers.add(buyer);
            user.setBuyers(buyers);

        }

        userDAO.save(user);

        return "Buyer creer avec succès";

    }
    */

