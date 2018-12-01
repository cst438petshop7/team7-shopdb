package edu.csumb.cst438.shopdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.cst438.shopdb.users.Cart;
import edu.csumb.cst438.shopdb.users.Credit;
import edu.csumb.cst438.shopdb.users.Password;
import edu.csumb.cst438.shopdb.users.User;
import edu.csumb.cst438.shopdb.users.Username;


@Component
public class ShopDbSeeder implements CommandLineRunner {
    @Autowired
    IShopRepository shopRepo;

    @Override
    public void run(String... args) throws Exception {
        User John = new User(new Username("JohnDoe"), new Password("abc123"), new Credit(100), new Cart(Arrays.asList("item", "item")));
        User Jane = new User(new Username("JaneDoe"), new Password("abc123"),new Credit(75), new Cart(Arrays.asList("item", "item")));
        User Jr = new User(new Username("JrDoe"), new Password("abc123"), new Credit(10), new Cart(Arrays.asList("item", "item")));
        shopRepo.deleteAll(); 
        List<User> users = Arrays.asList(John, Jane, Jr);
        shopRepo.saveAll(users);
    }

}