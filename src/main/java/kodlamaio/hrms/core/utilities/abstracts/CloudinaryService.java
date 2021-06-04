package kodlamaio.hrms.core.utilities.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	
	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;

}
