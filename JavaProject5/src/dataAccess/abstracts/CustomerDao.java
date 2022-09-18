package dataAccess.abstracts;

import entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerDao {
    void add(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);

    Customer get(int id);

    List<Customer> getCustomers();
}
