package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationInformation;

@RestController
@RequestMapping("/api/educationinformations")
public class EducationInformationsController {
	
	private EducationInformationService educationInformationService;
   
	@Autowired
	public EducationInformationsController(EducationInformationService educationInformationService) {
		super();
		this.educationInformationService = educationInformationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
		//return new Result(true,"Ürün eklendi");
		
	}

}
