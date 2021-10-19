package kodlamaio.hrms.core.Adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Component
public class CloudinaryManager implements CloudinaryService {

	private Cloudinary cloudinary;

	public CloudinaryManager() {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("cloud_name", "emineozbek");
		valuesMap.put("api_key", "177278466145182");
		valuesMap.put("api_secret", "NsF8fvSqPH9CBRmVHYMz5fjDuk4");
		cloudinary = new Cloudinary(valuesMap);
	}

	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		File file;
		try {
			file = convert(multipartFile);
			Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return new SuccessDataResult<>(result);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>("Dosya yuklenemedi");
		}
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return new SuccessDataResult<>(result);
	}

	private File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();

		return file;
	}
}
