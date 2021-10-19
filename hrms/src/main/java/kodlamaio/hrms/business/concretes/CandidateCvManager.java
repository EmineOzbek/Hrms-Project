package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class CandidateCvManager implements CandidateCvService {

	private CandidateCvDao candidateCvDao;

	@Lazy
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		super();
		this.candidateCvDao = candidateCvDao;
	}

	@Override
	public Result add(CandidateCv entity) {
		this.candidateCvDao.save(entity);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public Result delete(CandidateCv entity) {
		this.candidateCvDao.delete(entity);
		return new SuccessResult("Cv silindi.");
	}

	@Override
	public Result update(CandidateCv entity) {
		this.candidateCvDao.save(entity);
		return new SuccessResult("Cv güncellendi.");
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		return new SuccessDataResult<List<CandidateCv>>
		(this.candidateCvDao.findAll(), "Cv'ler listelendi" );
	}

	@Override
	public DataResult<List<CandidateCv>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateCv>>
		(this.candidateCvDao.getByCandidateId(candidateId),
				"Adayın cv'si getirildi");
	}

	@Override
	public DataResult<CandidateCvDto> getCandidateCvWithByCandidateIdDetails(int candidateId) {
		// TODO Auto-generated method stub
		return null;
	}

}
