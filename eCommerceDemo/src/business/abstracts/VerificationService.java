package business.abstracts;

public interface VerificationService {
    void sendToVerifyMail(String email);

    boolean ifClickedLink(String email);

    boolean checkVerifyAccount(String email);
}
