package kodlamaio.hrms.entities.dto;

import java.util.List;

import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import lombok.Data;

@Data 
public class CurriculumVitaeDto {
	
	private int id;
	private Jobseeker jobseeker;
	private List<EducationInformation> educationInformations;
	private List<ForeignLanguageInformation> foreignLanguageInformations;
	private List<WorkExperience>  workExperiences;
	

}
