package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position,Integer>{
	
	DataResult<List<Position>> findByNameIs(String name);

}
