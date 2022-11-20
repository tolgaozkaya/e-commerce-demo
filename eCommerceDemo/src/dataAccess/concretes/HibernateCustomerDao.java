package dataAccess.concretes;

import dataAccess.abstracts.CustomerDao;
import entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerDao implements CustomerDao {

    List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        System.out.println("Save to database with hibernate: " + customer.getFirstName());
        customers.add(customer);
    }

    @Override
    public void update(Customer customer) {
        System.out.println("Update to database: " + customer.getFirstName());
    }

    @Override
    public void delete(Customer customer) {
        System.out.println("Delete from database: " + customer.getFirstName());
    }

    @Override
    public Customer get(int id) {
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
