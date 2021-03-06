package kodlamaio.hrms.business.concretes;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;

	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {

		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), "Jobseekers are listed.");
	}

	@Override
	public Result add(Position position) {

		if (this.getByPositionName(position.getPositionName()).getData() == null) {
			this.positionDao.save(position);
			return new SuccessResult("Job position is added.");
		} else {
			return new ErrorResult("Job position is already exists.");
		}

	}


	@Override
	public DataResult<Position> getByPositionName(String positionName) {

		return new SuccessDataResult<Position>(this.positionDao.getByPositionName(positionName), "Data Listelendi");
	}
}
