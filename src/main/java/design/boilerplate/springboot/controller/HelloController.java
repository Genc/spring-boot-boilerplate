package design.boilerplate.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {

		return ResponseEntity.ok("Hello Spring Boot Boilerplate");
	}

}
