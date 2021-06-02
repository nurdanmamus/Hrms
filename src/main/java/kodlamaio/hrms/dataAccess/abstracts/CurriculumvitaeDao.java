package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CurriculumVitae;


public interface CurriculumvitaeDao extends JpaRepository<CurriculumVitae,Integer>{

}
