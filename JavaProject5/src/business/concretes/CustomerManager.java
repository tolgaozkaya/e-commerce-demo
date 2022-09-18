package business.concretes;

import business.abstracts.CustomerService;
import business.abstracts.VerificationService;
import core.LogInService;
import dataAccess.abstracts.CustomerDao;
import entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements CustomerService {

    List<Customer> customers = new ArrayList<Customer>();
    private CustomerDao customerDao;
    private CustomerCheckManager customerCheckManager;
    private VerificationService verificationService;

    public CustomerManager() {
    }

    public CustomerManager(CustomerDao customerDao, CustomerCheckManager customerCheckManager, VerificationService verificationService) {
        this.customerDao = customerDao;
        this.customerCheckManager = customerCheckManager;
        this.verificationService = verificationService;
    }

    @Override
    public void logIn(String email, String password) {
        List<Customer> newCustomerList = customerDao.getCustomers();
        Customer customer1 = null;
        for (Customer customerDB : newCustomerList) {
            if (customerDB.getEmail() == email && customerDB.getPassword() == password) {
                System.out.println("Giris basarili " + customerDB.getFirstName() + " " + customerDB.getLastName());
                customer1 = customerDB;
            } else if (customerDB.getEmail() == email && customerDB.getPassword() != password) {
                System.out.println("Şifre hatalı, kontrol ediniz..");
                customer1 = customerDB;
            }
        }
        if (customer1 == null) {
            System.out.println("bilgilerinizi kontrol ediniz..");
        }
    }

    public void withAdapterLogin(LogInService logInService, Customer customer) {
        logInService.logIn(customer);
    }

    @Override
    public void signUp(Customer customer) {
        if (customerCheckManager.isValid(customer) == true) {
            System.out.println("Kayıt başarılı..");
            verificationService.sendToVerifyMail(customer.getEmail());
            System.out.println("Kaydınızı tamalamak için doğrulama linkine tiklayiniz lütfen..");
            if (verificationService.checkVerifyAccount(customer.getEmail())) {
                System.out.println("Kaydınız tamamlandı..");
                customerDao.add(customer);
            }
        }
    }
}
