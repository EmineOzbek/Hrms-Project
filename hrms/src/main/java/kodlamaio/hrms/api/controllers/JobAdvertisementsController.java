package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@GetMapping("/setActiveToPassive")
	public Result setActiveToPassive(@RequestParam int id) {
		return this.jobAdvertisementService.setActiveToPassive(id);
	}

	@GetMapping("/getAllActiveJobAdverts")
	public DataResult<List<JobAdvertisementDto>> getAllActiveJobAdverts() {
		return this.jobAdvertisementService.getAllActiveJobAdverts();
	}

	@GetMapping("/getAllActiveJobAdvertsSortedByDate")
	public DataResult<List<JobAdvertisementDto>> getAllActiveJobAdvertsSortedByDate() {
		return this.jobAdvertisementService.getAllActiveJobAdvertsSortedByDate();
	}

	@GetMapping("/getAllActiveJobAdvertsSortedOfCompany")
	public DataResult<List<JobAdvertisementDto>> getAllActiveJobAdvertsSortedOfCompany(
			@RequestParam String companyName) {
		return this.jobAdvertisementService.getAllActiveJobAdvertsSortedOfCompany(companyName);
	}

}
