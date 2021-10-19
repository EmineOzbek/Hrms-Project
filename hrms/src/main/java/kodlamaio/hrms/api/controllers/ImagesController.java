package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody MultipartFile image,@RequestParam int candidateId) {
		return this.imageService.add(image, candidateId);
	}

	@DeleteMapping("/delete")
	public Result delete(int id) throws Exception {
		return this.imageService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Image> getById(int candidateId) {
		return this.imageService.getById(candidateId);
	}

}
