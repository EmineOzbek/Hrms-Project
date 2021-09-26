package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	 //İş verenler sisteme iş ilanı ekleyebilir.
	 Result add(JobAdvertisement jobAdvertisement);
	
	 //İş verenler sistemdeki bir ilanı kapatabilirler.
	 Result setActiveToPassive(int id);
	 
	 //Sistemdeki tüm aktif iş ilanları listelenir.
	 DataResult<List<JobAdvertisementDto>>  getAllActiveJobAdverts();
	 
	 //Sistemdeki tüm aktif iş ilanları tarihe göre listelenir.
	 DataResult<List<JobAdvertisementDto>>  getAllActiveJobAdvertsSortedByDate();
	 
	 //Sistemdeki bir firmaya ait tüm aktif iş ilanları listelenir.
	 DataResult<List<JobAdvertisementDto>> getAllActiveJobAdvertsSortedOfCompany(String companyName);

	 

}
