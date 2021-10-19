package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessDataResult<>("Deneyim bilgileri eklendi.");
	}

	@Override
	public Result delete(Experience id) {
		this.experienceDao.delete(id);
		return new SuccessDataResult<>("Deneyim bilgileri silindi.");
	}

	@Override
	public Result update(Experience experience) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<>("Deneyim bilgileri güncellendi.");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>
		(this.experienceDao.findAll(), "Deneyim bilgileri güncellendi.");
	}

}
