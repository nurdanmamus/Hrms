package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dto.JobDto;
import kodlamaio.hrms.entities.dto.ListJobDto;


@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobDto jobDto) {
//		System.out.println(jobDto.getCompanyName());
//		System.out.println(jobDto.getPositionName());
		return this.jobService.add(jobDto);		
	}
	
	@GetMapping("/getallActiveJob")
	public DataResult<List<ListJobDto>> findByActiveTrue(){
		return this.jobService.findByActiveTrue();
	}
    
	
	@GetMapping("/getallActiveJobOrderByReleaseDate")
	public DataResult<List<ListJobDto>> findByReleaseDateOrderByReleaseDate(@RequestParam String releaseDate){
		return this.jobService.findByReleaseDateAndActiveTrue(releaseDate);
	}
	
	@GetMapping("/getallEmployerActiveJob")
	public DataResult<List<ListJobDto>> findByEmployerId(@RequestParam int employerId){
		return this.jobService.findByEmployerId(employerId);
	}
	
	@PostMapping("/pasif")
	public Result updateJobSetActiveForId(@RequestParam int id){
		return this.jobService.updateJobSetActiveForId(false, id);
	}

}
