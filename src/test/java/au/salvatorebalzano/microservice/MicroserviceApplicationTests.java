package au.salvatorebalzano.microservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroserviceApplicationTests {

	@Test
	void contextLoads() {
		System.out.print("Test context loads");
	}

	@Test
	void testPlayer() {
		System.out.print("Test Player Model");
	}

}
