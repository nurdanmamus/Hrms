package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.dto.JobDto;
import kodlamaio.hrms.entities.dto.ListJobDto;

public interface JobService {
	
	Result add(JobDto jobDto);
	DataResult<List<ListJobDto>> findByActiveTrue();
	DataResult<List<ListJobDto>> findByReleaseDateAndActiveTrue(String releaseDate);
	
	DataResult<List<ListJobDto>> findByEmployerId(int employerId);
	
	Result updateJobSetActiveForId(Boolean active, int id);

}
