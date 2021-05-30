package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Job;


public interface JobDao extends JpaRepository<Job,Integer>{
	
	List<Job> findByActiveTrue();
	
//	@Query("From Job where active = true")
	List<Job> findByReleaseDateAndActiveTrue(LocalDate ReleaseDate);
	
//	List<Job> findByEmployer_CompanyName(int companyName);
	
	List<Job> findByEmployer_Id(int employerId);
	
	@Transactional
	@Modifying
	@Query("update Job j set j.active =:active where j.id =:id")
    void updateJobSetActiveForId(@Param("active") Boolean active, 
			  @Param("id") int id); 

}
