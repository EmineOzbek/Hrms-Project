package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public Result setActiveToPassive(int id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		jobAdvertisement.setIsActive(!jobAdvertisement.getIsActive());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessDataResult<>("İlan kapatıldı.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllActiveJobAdverts() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllActiveJobAdverts(),
				"Sistemdeki tüm aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllActiveJobAdvertsSortedByDate() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getAllActiveJobAdvertsSortedByDate(),
				"Sistemdeki tüm aktif iş ilanları tarihe göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllActiveJobAdvertsSortedOfCompany(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getAllActiveJobAdvertsSortedOfCompany(companyName),
				"İstenen firmaya ait tüm aktif iş ilanları listelendi.");
	}

}
