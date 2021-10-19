package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.CandidateCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCv;

@RestController
@RequestMapping("/api/candidateCvs")
public class CandidateCvsController {

	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateCv entity) {
		return this.candidateCvService.add(entity);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody CandidateCv entity) {
		return this.candidateCvService.delete(entity);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CandidateCv entity) {
		return this.candidateCvService.add(entity);
	}

	@GetMapping("/getAll")
	public DataResult<List<CandidateCv>> getAll() {
		return this.candidateCvService.getAll();
	}

	@GetMapping("/getByCandidateId")
	public DataResult<List<CandidateCv>> getByCandidateId(int candidateId) {
		return this.candidateCvService.getByCandidateId(candidateId);
	}
}
