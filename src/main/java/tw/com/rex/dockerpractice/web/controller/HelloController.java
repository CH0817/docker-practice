package tw.com.rex.dockerpractice.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class HelloController {

    private Environment environment;

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi() {
        return ResponseEntity.ok("Hi~");
    }

    @GetMapping("/profiles")
    public ResponseEntity<String[]> getCurrentProfile() {
        return ResponseEntity.ok(environment.getActiveProfiles());
    }

}
