package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.abstracts.MailService;
import kodlamaio.hrms.core.utilities.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.entities.dto.JobseekerDto;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;

	private UserCheckService userCheckService;

	private MailService mailService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao, UserCheckService userCheckService, MailService mailService) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.userCheckService = userCheckService;
		this.mailService = mailService;
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {

		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll(), "Jobseekers are listed.");
	}

	@Override
	public Result add(JobseekerDto jobseekerDto) {

		Result result = PublicValidator.isValidRequest(jobseekerDto);

		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}

		if (this.getByEmailOrTckn(jobseekerDto.getEmail(), jobseekerDto.getTckn()).getData() != null) {
			return new ErrorResult("The user exists in the system");
		}

		if (!this.userCheckService.CheckIfRealPerson(jobseekerDto.getTckn(), jobseekerDto.getJobseekerName(),
				jobseekerDto.getSurname(), Integer.parseInt(jobseekerDto.getYearOfBirth()))) {
			return new ErrorResult(result.getMessage());
		}

		if (!mailService.sendMail(jobseekerDto.getEmail())) {
			return new ErrorResult("Mail is not sent");
		}

		if (!mailService.verifySignUp()) {
			return new ErrorResult("Mail verification is failed");
		}

		Jobseeker jobseeker = modelMapper.map(jobseekerDto, Jobseeker.class);
		this.jobseekerDao.save(jobseeker);

		return new SuccessResult();

	}

	@Override
	public DataResult<Jobseeker> getByEmailOrTckn(String email, String tckn) {

		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.getByEmailOrTckn(email, tckn), "Data Listelendi");
	}

}
