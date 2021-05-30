package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dto.EmployerDto;
import kodlamaio.hrms.entities.dto.JobseekerDto;

public class PublicValidator {
	
	static {
	}
	
	public PublicValidator() {

	}
	
	public static Result isValidRequest(JobseekerDto jobseekerDto) {
		if (jobseekerDto.getEmail() != null && jobseekerDto.getJobseekerName() != null && jobseekerDto.getPassword() != null
				&& jobseekerDto.getSurname() != null && jobseekerDto.getTckn() != null && jobseekerDto.getYearOfBirth() != null) {
			return new SuccessResult("Başarılı");
		} else {

			System.out.println(jobseekerDto.getJobseekerName());

			return new ErrorResult("Fill in all required fields.");
		}
		
		
	}
	
	
	public static Result isValidRequest(EmployerDto employerDto) { 
		if (employerDto.getEmail() != null && employerDto.getPassword() != null && employerDto.getPhoneNo() != null
				&& employerDto.getWebsite() != null && employerDto.getCompanyName() != null ) {
			return new SuccessResult("Başarılı");
		} else {
			return new ErrorResult("Fill in all required fields.");
		}
	}

}
