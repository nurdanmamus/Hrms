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
@Table(name = "work_experiences")
@Entity
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitae" }) 
public class WorkExperience {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@JoinColumn(name = "cv_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae; 
	
	@Column(name="workplace_name")
	private String workplaceName;
	
	
	@NotBlank
	@NotNull
    @ManyToOne()
	@JoinColumn(name="position_id")
	private Position position;
	
	@NotBlank
	@NotNull
	@Column(name = "beginning_date")
	private LocalDate beginningDate;

	@Column(name = "finish_date")
	private LocalDate finishDate;

}
