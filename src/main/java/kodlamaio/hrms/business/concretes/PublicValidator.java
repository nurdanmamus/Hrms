package kodlamaio.hrms.business.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	
	// bu methodu nasıl handle ediyoruz?->bu sistemde şu tür hata olursa bu methodu devreye sok
	//not null gibi , required gibi tipleri methodargumentnotvalidexception ile tanımlıyoruz
	//sistemde bir hata oluşursa bu methodu çağır
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationError = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationError,"Doğrulama hataları");
		return errors;
		
	}

}
