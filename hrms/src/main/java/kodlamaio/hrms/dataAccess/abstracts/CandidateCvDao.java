package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer> {

	List<CandidateCv> getByCandidateId(int candidateId);

}
