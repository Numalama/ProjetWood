package fr.cesi.BasicWebServiceSpring.controller;

import fr.cesi.BasicWebServiceSpring.entity.User;
import fr.cesi.BasicWebServiceSpring.http.Response;
import fr.cesi.BasicWebServiceSpring.repository.UserDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserResourcesController extends AbstractSecureController {

    @Autowired
    private UserDAO UserDao;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<Response> getUserInfos() {
        User user = this.getUser();
        return this.responseSuccess(user);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return UserDao.save(user);
    }
}
