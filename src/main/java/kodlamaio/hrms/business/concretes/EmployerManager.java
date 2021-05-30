package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

import kodlamaio.hrms.entities.dto.EmployerDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	private MailService mailService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public EmployerManager(EmployerDao employerDao, MailService mailService) {
		super();
		this.employerDao = employerDao;
		this.mailService = mailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(EmployerDto employerDto) {

		Result result = PublicValidator.isValidRequest(employerDto); 

		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}

		if (this.employerDao.getByEmail(employerDto.getEmail()) != null) {
			return new ErrorResult("The user exists in the system");
		}

		if (!mailService.sendMail(employerDto.getEmail())) {
			return new ErrorResult("Mail is not sent");
		}

		if (!mailService.verifySignUp()) {
			return new ErrorResult("Mail verification is failed");
		}

		Employer employer = modelMapper.map(employerDto, Employer.class);
		this.employerDao.save(employer);

		return new SuccessResult();

	}

}
