package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageInformationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;

@RestController
@RequestMapping("/api/foreignlanguageinformations")
public class ForeignLanguageInformationsController {

	private ForeignLanguageInformationService foreignLanguageInformationService;
    
	@Autowired
	public ForeignLanguageInformationsController(ForeignLanguageInformationService foreignLanguageInformationService) {
		super();
		this.foreignLanguageInformationService = foreignLanguageInformationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguageInformation foreignLanguageInformation) {
		return this.foreignLanguageInformationService.add(foreignLanguageInformation);
		
	}
 
}
