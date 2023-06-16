package sicavibe.sicavibeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@SpringBootApplication
@Controller
public class SicaVibeAppApplication {

	public static JwtUtils jwtUtils = new JwtUtils();

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

	@GetMapping("/")
	public RedirectView redirectWithUsingRedirectView(
			RedirectAttributes attributes) {
		attributes.addFlashAttribute("flashAttribute", "/");
		attributes.addAttribute("attribute", "/");
		return new RedirectView("/swagger-ui.html");
	}

}
