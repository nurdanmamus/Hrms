package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="employer_id", referencedColumnName="id")
public class Employer extends User{

/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id") 
	private int employerId;
*/
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone_no") 
	private String phoneNo;

}
