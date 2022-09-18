import business.concretes.CustomerCheckManager;
import business.concretes.CustomerManager;
import business.concretes.EmailVerificationManager;
import core.FacebookLoginAdapter;
import core.GoogleLoginAdapter;
import dataAccess.concretes.HibernateCustomerDao;
import entities.concretes.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "tolga", "özkaya", "tolga@gmail.com", "123456");
        CustomerManager customerManager = new CustomerManager(new HibernateCustomerDao(), new CustomerCheckManager(), new EmailVerificationManager());
        customerManager.signUp(customer);

        customerManager.logIn("tolga@gmail.com", "123456");

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        CustomerManager customerManagerAdaptor = new CustomerManager();
        customerManagerAdaptor.withAdapterLogin(new GoogleLoginAdapter(), customer);
        customerManagerAdaptor.withAdapterLogin(new FacebookLoginAdapter(), customer1);

    }
}
