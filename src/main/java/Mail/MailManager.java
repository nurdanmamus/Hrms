package Mail;

public class MailManager {
	
	public void mailSend(String email) {
		System.out.println("Doğrulama maili ilgili mail adresine gönderildi." + email);
	}
	
	public boolean verifySignUp() {
		System.out.println("Üyelik işleminiz tamamlanmıştır.");
		return true;
	}

}
