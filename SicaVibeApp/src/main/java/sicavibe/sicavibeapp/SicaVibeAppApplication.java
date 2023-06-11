package sicavibe.sicavibeapp;

import org.orm.PersistentException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sicavibe.Hospede;
import sicavibe.HospedeDAO;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SicaVibeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SicaVibeAppApplication.class, args);
	}

	@Configuration
	public class WebConfiguration implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedMethods("*");
		}
	}

	@GetMapping("/hospedes")
	public List<Hospede> getHospedes(){
		try {
			return Arrays.stream(HospedeDAO.listHospedeByQuery(null,null)).toList();
		} catch (PersistentException e) {
			throw new RuntimeException(e);
		}
	}

}
