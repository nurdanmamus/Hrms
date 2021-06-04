package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CurriculumVitae;


public interface CurriculumvitaeDao extends JpaRepository<CurriculumVitae,Integer>{
	
	
	CurriculumVitae getByIdAndJobseeker_Id(int id, int jobseekerId);
	CurriculumVitae getById(int id);

}
