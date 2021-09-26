package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("FROM JobAdvertisement WHERE isActive = true")
	List<JobAdvertisementDto> getAllActiveJobAdverts();

	@Query("FROM JobAdvertisement WHERE isActive = true ")
	List<JobAdvertisementDto> getAllActiveJobAdvertsSortedByDate();

	@Query("FROM JobAdvertisement WHERE isActive = true AND employer.companyName = companyName")
	List<JobAdvertisementDto> getAllActiveJobAdvertsSortedOfCompany(String companyName);
}
