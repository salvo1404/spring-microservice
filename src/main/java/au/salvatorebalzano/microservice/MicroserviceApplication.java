package au.salvatorebalzano.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@GetMapping("/")
	public ResponseEntity<String> home(@RequestHeader Map<String, String> headers) {
		String userAgent = headers.getOrDefault("user-agent", "MacBook");
		headers.forEach((key, value) -> {
			System.out.printf("Header '%s' = %s%n", key, value);
		});

		return new ResponseEntity<String>(
			String.format("Hello %s!", userAgent), HttpStatus.OK);
	}
}
