package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface EmailCheckService {

	boolean verificationEmail(String email);

	boolean confirmEmail(User user);

}
