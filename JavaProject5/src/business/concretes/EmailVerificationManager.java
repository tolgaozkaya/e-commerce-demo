package business.concretes;

import business.abstracts.VerificationService;

public class EmailVerificationManager implements VerificationService {

    @Override
    public void sendToVerifyMail(String email) {
        System.out.println("Doğrulama linki gönderildi..");
    }

    @Override
    public boolean ifClickedLink(String email) {
        return true;
    }

    @Override
    public boolean checkVerifyAccount(String email) {
        if (ifClickedLink(email) == true) {
            System.out.println("Hesap dogrulanmıstır..");
            return true;
        }
        return false;
    }

}
