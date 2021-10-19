
package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.Adapters.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CandidateService candidateService;
	private CloudinaryService cloudinaryService;

	@Autowired
	public ImageManager(ImageDao imageDao, CandidateService candidateService, CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.candidateService = candidateService;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(MultipartFile multipartFile, int candidateId) {
		var result = this.cloudinaryService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		var candidate = this.candidateService.getById(candidateId).getData();
		Image image = new Image();
		image.setCandidate(candidate);
		image.setImageUrl(result.getData().get("url"));
		image.setPublicId(result.getData().get("public_id"));
		image.setUploadedDate(result.getData().get("created_at"));
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf eklendi.");

	}

	@Override
	public Result delete(int id) throws Exception {
		var publicId = this.imageDao.findById(id).get().getPublicId();
		var result = this.cloudinaryService.delete(publicId);
		this.imageDao.deleteById(id);
		return new SuccessResult("Fotoğraf silindi.");
	}

	@Override
	public DataResult<Image> getById(int candidateId) {
		return new SuccessDataResult<Image>(this.imageDao.findById(candidateId).get());
	}
}