package kodlamaio.hrms.entities.dto;

import lombok.Data;

@Data
public class JobseekerDto {
	
	private String jobseekerName;
	private String surname;
	private String tckn;
	private String yearOfBirth;
	private String email;
	private String password;

}
