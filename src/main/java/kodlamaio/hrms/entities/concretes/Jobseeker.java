package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "jobseekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="jobseeker_id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Jobseeker extends User{

/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobseeker_id")
	private int jobseekerId;
*/	
	@Column(name = "name")
	private String jobseekerName;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "tckn")
	private String tckn;
	
	@Column(name = "year_of_birth")
	private String yearOfBirth;
	
	@OneToMany(mappedBy = "jobseeker")
	@JsonIgnore
	private List<CurriculumVitae> curriculumVitaes;
	
}
