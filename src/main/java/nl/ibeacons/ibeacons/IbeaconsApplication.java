package nl.ibeacons.ibeacons;

import nl.ibeacons.ibeacons.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(WebSecurityConfig.class)
public class IbeaconsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbeaconsApplication.class, args);
	}
}
