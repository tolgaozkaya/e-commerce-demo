package core;

import entities.concretes.Customer;

public class GoogleLoginAdapter extends LogInManager {
    public void logIn(Customer customer) {
        System.out.println("Google ile giris yapıldı");
    }
}


