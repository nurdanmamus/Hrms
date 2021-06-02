package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education_information")
@Entity
public class EducationInformation {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@JoinColumn(name = "cv_id")
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })	
	private CurriculumVitae curriculumVitae;
	
	@NotBlank 
	@NotNull
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank
	@NotNull
	@Column(name = "department_name")
	private String departmentName;
	

	@Column(name = "beginning_date")
	private LocalDate beginningDate;
	

	@Column(name = "finish_date")
	private LocalDate finishDate;

}
