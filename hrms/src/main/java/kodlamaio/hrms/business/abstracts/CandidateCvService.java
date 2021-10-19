package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCv;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidateCvService extends BaseService<CandidateCv>{

	DataResult<List<CandidateCv>> getByCandidateId(int candidateId);

	DataResult<CandidateCvDto> getCandidateCvWithByCandidateIdDetails(int candidateId);
}
