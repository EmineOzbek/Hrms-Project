package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface MernisCheckService {

	boolean checkIfRealPerson(User user);
}
