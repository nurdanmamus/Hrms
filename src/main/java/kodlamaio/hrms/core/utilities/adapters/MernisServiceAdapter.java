package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import tr.gov.nvi.tckimlik.WS.*;

@Service
public class MernisServiceAdapter implements UserCheckService{
	
	@Override
	public Boolean CheckIfRealPerson(String nationalId, String firstName, String lastName, int yearOfBirth) {
		
		return true;
		
/*		
       KPSPublicSoap client = new KPSPublicSoapProxy();
		
		try {
			boolean result = client.TCKimlikNoDogrula(Long.parseLong(nationalId), firstName,
					lastName, yearOfBirth) ;
			 
			return true;
		} catch (Exception e) {
			e.toString();
			return false;
		} 
*/
	} 

}
