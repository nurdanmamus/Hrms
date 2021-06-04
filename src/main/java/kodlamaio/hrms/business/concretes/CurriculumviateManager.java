package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumvitaeService;
import kodlamaio.hrms.core.utilities.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumvitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.dto.CurriculumVitaeDto;

@Service
public class CurriculumviateManager implements CurriculumvitaeService {

	private CurriculumvitaeDao curriculumvitaeDao;
	private ModelMapper modelMapper;
	private CloudinaryService cloudinaryService;

	@Autowired
	public CurriculumviateManager(CurriculumvitaeDao curriculumvitaeDao, ModelMapper modelMapper,
			CloudinaryService cloudinaryService) {
		super();
		this.curriculumvitaeDao = curriculumvitaeDao;
		this.modelMapper = modelMapper;
		this.cloudinaryService = cloudinaryService;
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

	@Override
	public DataResult<CurriculumVitaeDto> getByJobseekerId(int id, int jobseekerId) {

		CurriculumVitae curriculumVitae = this.curriculumvitaeDao.getByIdAndJobseeker_Id(id, jobseekerId);

		CurriculumVitaeDto curriculumVitaeDto = modelMapper.map(curriculumVitae, CurriculumVitaeDto.class);

		return new SuccessDataResult<CurriculumVitaeDto>(curriculumVitaeDto, "Cv'ler listelendi.");
//		curriculumVitae.getEducationInformations().forEach(EducationInformation-> EducationInformation.se);
//		return new SuccessDataResult<CurriculumVitae>(this.curriculumvitaeDao.getByIdAndJobseeker_Id(id, jobseekerId), "Cv'ler listelendi.");
	}

	@Override
	public Result uploadPhoto(int cvId, MultipartFile multipartFile) throws IOException {
		DataResult<Map> result= cloudinaryService.upload(multipartFile);
		CurriculumVitae curriculumVitae = this.curriculumvitaeDao.getById(cvId);
		curriculumVitae.setPhotoUrl(result.getData().get("url").toString());
		this.curriculumvitaeDao.save(curriculumVitae);
		return new SuccessResult("Fotoğraf yüklendi.");
			
	} 



}
