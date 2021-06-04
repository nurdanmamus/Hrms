package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.dto.CurriculumVitaeDto;



public interface CurriculumvitaeService {
	
	 Result add(CurriculumVitae curriculumVitae);
	 DataResult<List<CurriculumVitae>> getAll();
	 DataResult<CurriculumVitaeDto> getByJobseekerId(int id,int jobseekerId);
	 Result uploadPhoto(int cvId, MultipartFile file) throws IOException;

}
