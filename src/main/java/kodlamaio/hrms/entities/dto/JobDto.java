package kodlamaio.hrms.entities.dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class JobDto {

//	private int employer_id;
//	private int positionid;
	
//	private int employer_id;
//	private int id;
	private String companyName;
	private String positionName; 
	private String jobDescription;
	private double minSalary;
	private double maxSalary;
	private int numberOfOpenPosition;
//	private LocalDate applicationDeadline;
}
