package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumvitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumvitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class CurriculumviateManager implements CurriculumvitaeService{
	
	private CurriculumvitaeDao curriculumvitaeDao;
	
    @Autowired
	public CurriculumviateManager(CurriculumvitaeDao curriculumvitaeDao) {
		super();
		this.curriculumvitaeDao = curriculumvitaeDao;
	}


	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		// TODO Auto-generated method stub
		this.curriculumvitaeDao.save(curriculumVitae);

		return new SuccessResult();
	}


	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumvitaeDao.findAll(), "Cv'ler listelendi.");
	}

}
