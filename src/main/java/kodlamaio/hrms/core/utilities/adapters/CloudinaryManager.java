package kodlamaio.hrms.core.utilities.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements CloudinaryService{
	
	Cloudinary cloudinary; 
	
//	private Map<String, String> valuesMap = new HashMap();
	
	@Autowired
	public CloudinaryManager() {
		//valuesMap.put("cloud_name", "dwy15gvod");
		//valuesMap.put("api_key", "415338817677416"); 
		//valuesMap.put("api_secret", "Yifa5FsD_FvTPwtvoSTrQCwmbDQ");
		this.cloudinary = new Cloudinary("cloudinary://754226987463575:kmW_XTJQKtT82XjbuDYpRRunU2o@dw1fvmqsq");
	}

	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
		Map upload = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(upload);
	}

}
