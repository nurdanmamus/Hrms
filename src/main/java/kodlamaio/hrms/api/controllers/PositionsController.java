package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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

	// kodlama.oi/api/positions/getall -> böyle bir istek gelirse bu class
	// karşılayacak
	@GetMapping("/getall")
	public DataResult<List<Position>> getAll() {
		return this.positionService.getAll();
		// return new DataResult(this.productService.getAll(),false,null);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Position position) {
		return this.positionService.add(position);
		// return new Result(true,"Ürün eklendi");

	}
    
	@GetMapping("/getByPositionName")
	public DataResult<Position> getByPositionName(@RequestParam String positionName) {
		return this.positionService.getByPositionName(positionName);
	}

}
