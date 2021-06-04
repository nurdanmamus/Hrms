package kodlamaio.hrms.entities.dto;

import java.time.LocalDate;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Position;
import lombok.Data;

@Data
public class ListJobDto {
	
//	private String companyName;
//	private String positionName;
	private Employer employer;
	private Position position;
	private int numberOfOpenPosition;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;

}
