package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumvitaeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;


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
	
	@GetMapping("/getdetail")
	public ResponseEntity<?> getallbyjobseekerid(@RequestParam int id, @RequestParam int jobseekerId) {
		return ResponseEntity.ok(this.curriculumvitaeService.getByJobseekerId(id , jobseekerId));
	}
	
	@PostMapping("/uploadPhoto")
	public Result uploadPhoto(@RequestParam int cvId, @RequestParam("file") MultipartFile multipartFile) throws IOException{
		return curriculumvitaeService.uploadPhoto(cvId, multipartFile);
	}
	
	
	
	
	
	

}
