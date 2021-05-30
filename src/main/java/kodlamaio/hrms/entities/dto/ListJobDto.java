package kodlamaio.hrms.entities.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ListJobDto {
	
	private String companyName;
	private String positionName;
	private int numberOfOpenPosition;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;

}
