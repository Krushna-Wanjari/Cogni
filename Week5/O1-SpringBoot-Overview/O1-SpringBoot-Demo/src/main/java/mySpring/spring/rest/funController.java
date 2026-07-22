package mySpring.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
