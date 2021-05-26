package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import Mail.MailManager;
import kodlamaio.hrms.core.utilities.abstracts.MailService;

@Service
public class MailManagerAdapter implements MailService{

	@Override
	public boolean sendMail(String mail) {
		MailManager mailManager = new MailManager();
		mailManager.mailSend(mail);
		return true;
	}

	@Override
	public boolean verifySignUp() {
		MailManager mailManager = new MailManager();
		mailManager.verifySignUp();
		return true;
	}

}
