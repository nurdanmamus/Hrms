package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education_informations")
@Entity
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitae" }) 
public class EducationInformation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@NotNull
	@JoinColumn(name = "cv_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae;

	@NotBlank
	@NotNull
    @ManyToOne()
	@JoinColumn(name="school_id")
	private School school; 
//	private String schoolName;

	@NotBlank
	@NotNull
	@Column(name = "department_name")
	private String departmentName;

	@NotBlank
	@NotNull
	@Column(name = "beginning_date")
	private LocalDate beginningDate;

	@Column(name = "finish_date")
	private LocalDate finishDate;

	@Column(name = "graduated")
	private Boolean graduated;

}
