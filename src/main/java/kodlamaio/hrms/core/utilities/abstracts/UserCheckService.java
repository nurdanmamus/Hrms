package kodlamaio.hrms.core.utilities.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface UserCheckService {
	
	Boolean CheckIfRealPerson(String nationalId, String firstName, String lastName, int yearOfBirth);
}
