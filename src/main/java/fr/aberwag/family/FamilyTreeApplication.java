package fr.aberwag.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@SpringBootApplication
@EntityScan("fr.aberwag.family.domain")
public class FamilyTreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyTreeApplication.class, args);
	}
}
