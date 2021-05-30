package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dto.JobseekerDto;

public interface JobseekerService {
   
	DataResult<List<Jobseeker>> getAll();
	Result add(JobseekerDto jobseekerDto);
	DataResult<Jobseeker> getByEmailOrTckn(String email, String tckn);

}
