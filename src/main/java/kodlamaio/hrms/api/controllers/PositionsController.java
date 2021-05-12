package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.entities.concretes.Position;


@RestController
@RequestMapping("/api/positions")
public class PositionsController {
	
	private PositionService positionService;
	
	@Autowired
	public PositionsController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}

		//kodlama.oi/api/positions/getall -> böyle bir istek gelirse bu class karşılayacak
		@GetMapping("/getall")
		public List<Position> getAll(){
			//api-> bussiness-> dataAccedd
			return this.positionService.getAll();
		}

}
