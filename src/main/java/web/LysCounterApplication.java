package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableMongoRepositories(basePackages = {"document","repo"})
@EnableMongoAuditing
@SpringBootApplication
@EnableSwagger2
public class LysCounterApplication {





	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(LysCounterApplication.class, args);

	}


}