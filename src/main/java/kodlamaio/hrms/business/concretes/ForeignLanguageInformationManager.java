package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageInformationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageInformationDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguageInformation;

@Service
public class ForeignLanguageInformationManager implements ForeignLanguageInformationService{
	
	private ForeignLanguageInformationDao foreignLanguageInformationDao;
   
	@Autowired
	public ForeignLanguageInformationManager(ForeignLanguageInformationDao foreignLanguageInformationDao) {
		super();
		this.foreignLanguageInformationDao = foreignLanguageInformationDao;
	}

	@Override
	public Result add(ForeignLanguageInformation foreignLanguageInformation) {
		this.foreignLanguageInformationDao.save(foreignLanguageInformation);

		return new SuccessResult();
	}

}
