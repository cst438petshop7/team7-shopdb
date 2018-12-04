package edu.csumb.cst438.shopdb.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
    @Id
    private String id;
    private Username username;
    private Password password;
    private Cart cart;
    private Credit credit;

    public User (Username username, Password password, Credit credit, Cart cart) {
        this.username = username;
        this.password = password;
        this.cart = cart;
        this.credit = credit;
    }

    public String getId() {
        return this.id;
    }

    public Username getUsername() {
        return this.username;
    }
    
    public Password getPassword() {
    	return this.password;
    }

    public Cart getCartItems() {
        return this.cart;
    }

    public Credit getCredit() {
        return this.credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

}
