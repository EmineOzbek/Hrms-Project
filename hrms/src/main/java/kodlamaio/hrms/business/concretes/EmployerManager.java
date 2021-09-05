package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailCheckService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.HrmsCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailCheckService emailCheckService;
	private HrmsCheckService hrmsCheckService;

	@Lazy
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailCheckService emailCheckService, HrmsCheckService hrmsCheckService) {
		super();
		this.employerDao = employerDao;
		this.emailCheckService = emailCheckService;
		this.hrmsCheckService = hrmsCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		
		if(employer.getCompanyName()!=null || employer.getWebSite()!=null|| employer.getEmail()!=null 
				|| employer.getPhoneNumber()!=null || employer.getPassword()!=null) {
			return new ErrorResult("Tüm alanları doldurun.");
			
		}else if(!emailCheckService.verificationEmail(employer.getEmail())) {
			return new ErrorResult("Email adresi ile kayıt yapılmış! Lütfen daha önce kullanılmamış bir email adresi giriniz.");
		
		}else if(!emailCheckService.confirmEmail(employer)) {
			return new ErrorResult("Lütfen email adresinizi onaylayınız.");
			
		}else if(!hrmsCheckService.checkIfConfirmOfHrms()) {
			return new ErrorResult("Hrms onayı alamadınız.");
		}
	
		this.employerDao.save(employer);
		return new SuccessResult("İş veren eklendi.");
	}

}
