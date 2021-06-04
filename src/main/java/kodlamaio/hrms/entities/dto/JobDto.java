package kodlamaio.hrms.entities.dto;

import java.time.LocalDate;



import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Position;
import lombok.Data;

@Data
public class JobDto {

//	private String companyName;
//	private String positionName; 
	private Employer employer;
	private Position position;
	private City city;
	private String jobDescription;
	private double minSalary;
	private double maxSalary;
	private int numberOfOpenPosition;
//	private LocalDate applicationDeadline;
}
