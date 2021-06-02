package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CurriculumvitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/curriculumvitaes")
public class CurriculumvitaesController {
	
	private CurriculumvitaeService curriculumvitaeService;
    
	@Autowired
	public CurriculumvitaesController(CurriculumvitaeService curriculumvitaeService) {
		super();
		this.curriculumvitaeService = curriculumvitaeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumvitaeService.add(curriculumVitae);
		//return new Result(true,"Ürün eklendi");
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll() {
		return this.curriculumvitaeService.getAll();
		// return new DataResult(this.productService.getAll(),false,null);
	}

}
