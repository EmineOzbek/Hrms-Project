package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/educations")
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return this.educationService.add(education);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam Education id) {
		return this.educationService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Education education) {
		return this.educationService.update(education);
	}

	@GetMapping("/getall")
	public DataResult<List<Education>> getAll() {
		return this.educationService.getAll();
	}

}
