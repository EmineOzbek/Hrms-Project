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
import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/coverLetters")
public class CoverLettersController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam CoverLetter id) {
		return this.coverLetterService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.update(coverLetter);
	}

	@GetMapping("/getall")
	public DataResult<List<CoverLetter>> getAll() {
		return this.coverLetterService.getAll();
	}
}
