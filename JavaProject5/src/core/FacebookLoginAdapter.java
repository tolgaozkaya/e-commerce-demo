package core;

import entities.concretes.Customer;

public class FacebookLoginAdapter implements LogInService {
    @Override
    public void logIn(Customer customer) {
        System.out.println("Facebook ile giriş yapıldı...");
    }
}
