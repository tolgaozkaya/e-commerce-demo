package business.abstracts;

import entities.concretes.Customer;

public interface CustomerService {
    void logIn(String mail, String password);

    void signUp(Customer customer);
}
