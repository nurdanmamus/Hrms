package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.dto.JobDto;
import kodlamaio.hrms.entities.dto.ListJobDto;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	private ModelMapper modelMapper;
	private EmployerDao employerDao;
	private PositionDao positionDao;

	@Autowired
	public JobManager(JobDao jobDao, ModelMapper modelMapper, EmployerDao employerDao, PositionDao positionDao) {
		super();
		this.jobDao = jobDao;
		this.modelMapper = modelMapper;
		this.employerDao = employerDao;
		this.positionDao = positionDao;
	}

	@Override
	public Result add(JobDto jobDto) {

		Job job = modelMapper.map(jobDto, Job.class);
//		job.setEmployer(this.employerDao.getByCompanyName(jobDto.getCompanyName()));
//		job.setPosition(this.positionDao.getByPositionName(jobDto.getPositionName()));
		job.setActive(true);
		LocalDate localDate = LocalDate.now();
		job.setReleaseDate(localDate);

		this.jobDao.save(job);
		return new SuccessResult("Job dbye kayıt edildi.");
	}

	@Override
	public DataResult<List<ListJobDto>> findByActiveTrue() {

//		List<ListJobDto> listJobDtos = new ArrayList<>();
//		List<Job> jobs = this.jobDao.findByActiveTrue();

		/*
		 * jobs.forEach(item -> { ListJobDto listJobDto = modelMapper.map(item,
		 * ListJobDto.class);
		 * listJobDto.setCompanyName(item.getEmployer().getCompanyName());
		 * listJobDto.setPositionName(item.getPosition().getPositionName());
		 * listJobDtos.add(listJobDto); });
		 */

		return new SuccessDataResult<List<ListJobDto>>(this.convertEntityToDto(this.jobDao.findByActiveTrue()),
				"Aktif iş ilanları listelendi");
//		return new SuccessDataResult(listJobDtos, "listelendi");
	}

	private List<ListJobDto> convertEntityToDto(List<Job> jobs) {
		List<ListJobDto> listJobDtos = new ArrayList<>();

		jobs.forEach(item -> {
			ListJobDto listJobDto = modelMapper.map(item, ListJobDto.class);
//			listJobDto.setCompanyName(item.getEmployer().getCompanyName());
//			listJobDto.setPositionName(item.getPosition().getPositionName());
			listJobDtos.add(listJobDto);
		});

		return listJobDtos;
	}

	@Override
	public DataResult<List<ListJobDto>> findByReleaseDateAndActiveTrue(String releaseDate) {
		
		LocalDate date = LocalDate.parse(releaseDate);
//		System.out.println(date);
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ListJobDto>>(this.convertEntityToDto(this.jobDao.findByReleaseDateAndActiveTrue(date)),
				"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<ListJobDto>> findByEmployerId(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ListJobDto>>(this.convertEntityToDto(this.jobDao.findByEmployer_Id(employerId)),
				"Aktif iş ilanları listelendi");
	}

	@Override
	public Result updateJobSetActiveForId(Boolean active, int id) {
		this.jobDao.updateJobSetActiveForId(active, id);
		return new SuccessResult("ilan pasif edildi.");
	}

}
