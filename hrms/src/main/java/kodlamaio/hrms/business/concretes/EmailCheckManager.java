package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailCheckService;
import kodlamaio.hrms.dataAccess.abstracts.EmailDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailCheckManager implements EmailCheckService {

	private EmailDao emailDao;

	@Autowired
	public EmailCheckManager(EmailDao emailDao) {
		super();
		this.emailDao = emailDao;
	}

	@Override
	public boolean verificationEmail(String email) {
		List<User> candidateEmail = emailDao.findByEmail(email);
		if (candidateEmail.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean confirmEmail(User user) {

		return true;

	}
}
