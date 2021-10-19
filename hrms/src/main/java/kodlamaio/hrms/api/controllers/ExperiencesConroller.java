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
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/experiences")
public class ExperiencesConroller {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesConroller(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.add(experience);

	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam Experience id) {
		return this.experienceService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Experience experience) {
		return this.experienceService.update(experience);
	}

	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll() {
		return this.experienceService.getAll();
	}
}
