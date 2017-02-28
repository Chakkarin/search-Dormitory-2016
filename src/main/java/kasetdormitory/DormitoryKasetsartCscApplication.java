package kasetdormitory;


import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class DormitoryKasetsartCscApplication {

	/* public static String ROOT = "upload-dir"; */

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DormitoryKasetsartCscApplication.class, args);
	}


	 @Bean
	    MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        factory.setMaxFileSize("10027KB");
	        factory.setMaxRequestSize("10027KB");
	        return factory.createMultipartConfig();
	    }
	
	/*
	 * @Bean CommandLineRunner init() { return (String[] args) -> { new
	 * File(ROOT).mkdir(); }; }
	 */
}
