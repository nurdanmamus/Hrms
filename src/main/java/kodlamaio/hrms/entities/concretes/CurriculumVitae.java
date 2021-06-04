package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculumvitaes")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "educationInformation", "workExperiences" ,"foreignLanguageInformations"})
public class CurriculumVitae {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name = "cv_name")
	private String cvName;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "jobseeker_id") 
	private Jobseeker jobseeker;
	
	@Column(name="photo_url")
	private String photoUrl;

	@OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore()
	private List<EducationInformation> educationInformations;
	
	@OneToMany(mappedBy = "curriculumVitae")
	@JsonIgnore()
	private List<WorkExperience> workExperiences; 
	
	@OneToMany(mappedBy = "curriculumVitae")
	@JsonIgnore()
	private List<ForeignLanguageInformation> foreignLanguageInformations;
   
   
	
	

}

