package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dto.JobseekerDto;


@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersController {
	
	private JobseekerService jobseekerService;
    
	@Autowired 
	public JobseekersController(JobseekerService jobseekerService) { 
		super();
		this.jobseekerService = jobseekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Jobseeker>> getAll(){
		return this.jobseekerService.getAll();
		//return new DataResult(this.productService.getAll(),false,null);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobseekerDto jobseekerDto) {
		return this.jobseekerService.add(jobseekerDto);
		//return new Result(true,"Ürün eklendi");
		
	}

}
