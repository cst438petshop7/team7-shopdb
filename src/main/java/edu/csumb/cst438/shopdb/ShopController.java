package edu.csumb.cst438.shopdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.cst438.shopdb.users.Credit;
import edu.csumb.cst438.shopdb.users.User;

@RestController
public class ShopController {
    @Autowired
    IShopRepository shopRepository;

    @CrossOrigin(origins = "*")
    @GetMapping ("/allUsers")
    public List<User> getAll() {
        List<User> users = shopRepository.findAll();
        return users;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/id/{id}")
    public User getUserbyId (@PathVariable String id){
        User result = shopRepository.findByRepoId(id);
        return result;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/username/{username}")
    public User getByUserName(@PathVariable String username){
        User result = shopRepository.findByUsername(username);
        return result;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/update/{username}/{amount}")
    public User updateProduct(@PathVariable String username, @PathVariable double amount) {
        User userData = shopRepository.findByUsername(username);
        if (userData == null) { return null; }
        userData.setCredit(new Credit(userData.getCredit().getCredit() - amount));
        shopRepository.save(userData);
        return userData;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/increase/{username}/{amount}")
    public User increaseProduct(@PathVariable String username, @PathVariable double amount) {
        User userData = shopRepository.findByUsername(username);
        if (userData == null) { return null; }
        userData.setCredit(new Credit(userData.getCredit().getCredit() + amount));
        shopRepository.save(userData);
        return userData;
    }

}