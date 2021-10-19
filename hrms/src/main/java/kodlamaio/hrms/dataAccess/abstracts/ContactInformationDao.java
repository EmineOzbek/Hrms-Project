package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ContactInformation;

public interface ContactInformationDao extends JpaRepository<ContactInformation, Integer> {

}
