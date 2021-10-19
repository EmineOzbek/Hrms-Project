package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ContactInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ContactInformationDao;
import kodlamaio.hrms.entities.concretes.ContactInformation;

@Service
public class ContactInformationManager implements ContactInformationService {

	private ContactInformationDao contactInformationDao;

	@Autowired
	public ContactInformationManager(ContactInformationDao contactInformationDao) {
		super();
		this.contactInformationDao = contactInformationDao;
	}

	@Override
	public Result add(ContactInformation contactInformation) {
		this.contactInformationDao.save(contactInformation);
		return new SuccessResult("İletişim bilgileri eklendi.");
	}

	@Override
	public Result delete(ContactInformation id) {
		this.contactInformationDao.delete(id);
		return new SuccessResult("İletişim bilgileri silindi.");
	}

	@Override
	public Result update(ContactInformation entity) {
		// TODO Auto-generated method stub
		return new SuccessResult("İletişim bilgileri güncellendi.");
	}

	@Override
	public DataResult<List<ContactInformation>> getAll() {
		return new SuccessDataResult<List<ContactInformation>>(this.contactInformationDao.findAll(),
				"İletişim bilgileri listelendi.");
	}

}
