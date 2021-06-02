package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;



public interface CurriculumvitaeService {
	
	 Result add(CurriculumVitae curriculumVitae);
	 DataResult<List<CurriculumVitae>> getAll();

}
