package kodlamaio.hrms;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kodlamaio.hrms.entities.concretes.Jobseeker;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}

	// @EnableSwagger2 swagger'ı başlatıyor. Docket üzeerinden apileri buluyır ve
	// documente haline getiriyor.
	// config için kullanıyor. @bean 'i görünce belleğe yerleştiriyor.Docket ile
	// controllerlarlarda
	// request handleları bir dokümante haline getiriyor. bütün apileri bulup test
	// edilebilir hale getiriyor.
	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("kodlamaio.hrms")).paths(PathSelectors.any()).build();
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	} 

}
