package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailCheckService;
import kodlamaio.hrms.business.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private EmailCheckService emailCheckService;
	private MernisCheckService mernisCheckService;

	@Lazy
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailCheckService emailCheckService,
			MernisCheckService mernisCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.emailCheckService = emailCheckService;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi.");
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId).get(), "Data getirildi.");
	}

	@Override
	public Result add(Candidate candidate) {

		if (candidate.getFirstName() != null || candidate.getLastName() != null || candidate.getIdentityNumber() != null
				|| candidate.getBirtYear() != null || candidate.getEmail() != null) {
			return new ErrorResult("Tüm alanları doldurun.");

		} else if (!mernisCheckService.checkIfRealPerson(candidate)) {
			return new ErrorResult("Lütfen gerçek kişi bilgileri giriniz.");

		} else if (!emailCheckService.verificationEmail(candidate.getEmail())) {
			return new ErrorResult(
					"Email adresi ile kayıt yapılmış! Lütfen daha önce kullanılmamış bir email adresi giriniz.");

		} else if (!emailCheckService.confirmEmail(candidate)) {
			return new ErrorResult("Lütfen email adresinizi onaylayınız. ");

		} else if (!checkIfIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Bu TC kimlik numarası ile yapılmış!");
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan eklendi.");
	}

	private boolean checkIfIdentityNumber(String identityNumber) {
		if (this.candidateDao.findByIdentityNumber(identityNumber) == null) {
			return true;
		}
		return false;
	}

}
