package business.concretes;

import business.abstracts.CustomerCheckService;
import dataAccess.abstracts.CustomerDao;
import entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerCheckManager implements CustomerCheckService {

    @Override
    public boolean checkFirstName(Customer customer) {
        if (customer.getFirstName().isEmpty()) {
            System.out.println("İsim alanı boş olamaz.");
            return false;
        } else {
            if (customer.getFirstName().length() < 2) {
                System.out.println("İsim 2 karakterden daha küçük olamaz.");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkLastName(Customer customer) {
        if (customer.getLastName().isEmpty()) {
            System.out.println("Soyisim alanı boş bırakılamaz.");
            return false;
        } else {
            if (customer.getLastName().length() < 3) {
                System.out.println("Soyisim 2 karakterden daha küçük olamaz.");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkEmail(Customer customer) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (customer.getEmail().isEmpty()) {
            System.out.println("Email alanı boş bırakılamaz.");
            return false;
        } else {
            if (pattern.matcher(customer.getEmail()).find() == false) {
                System.out.println("Girilen email adresi formata uygun değil. Örnek: ornek@ornek.com");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkPassword(Customer customer) {
        if (customer.getPassword().isEmpty()) {
            System.out.println("Lutfen sifre giriniz..");
            return false;
        } else {
            if (customer.getPassword().length() < 6) {
                System.out.println("Parola 6 karaktereden daha küçük olamaz..");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean uniqueEmail(Customer customer) {
        return true;
    }

    @Override
    public boolean isValid(Customer customer) {
        if (checkFirstName(customer) && checkLastName(customer) && checkEmail(customer) && checkPassword(customer)
                && uniqueEmail(customer) == true) {
            return true;
        }
        return false;
    }
}
