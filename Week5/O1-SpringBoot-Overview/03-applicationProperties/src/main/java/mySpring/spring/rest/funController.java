package mySpring.spring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funController {

    @Value("${coach.name}")
    private String coach;

    @Value("${team.name}")
    private String team;

    @GetMapping("/team")
    public String teamHello(){
        return team + " " + coach;
    }


    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String doWorkOut(){
        return "Workout!";
    }
}
