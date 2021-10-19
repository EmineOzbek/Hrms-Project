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
import kodlamaio.hrms.business.abstracts.ContactInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ContactInformation;

@RestController
@RequestMapping("/api/contactInformations")
public class ContactInformationsController {

	private ContactInformationService contactInformationService;

	@Autowired
	public ContactInformationsController(ContactInformationService contactInformationService) {
		super();
		this.contactInformationService = contactInformationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ContactInformation contactInformation) {
		return this.contactInformationService.add(contactInformation);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam ContactInformation id) {
		return this.contactInformationService.delete(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody ContactInformation entity) {
		return this.contactInformationService.update(entity);
	}

	@GetMapping("/getall")
	public DataResult<List<ContactInformation>> getAll() {
		return this.contactInformationService.getAll();
	}

}
