package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {

	Result add(MultipartFile multipartFile, int candidateId);

	Result delete(int id) throws Exception;

	DataResult<Image> getById(int candidateId);
}
