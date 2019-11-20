package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    String message;

  @GetMapping("/")
    public String sayHello(){
        //return "hello";

     // return "A welcome message";
      return message;
    }

    public WelcomeController( //   Injects the WELCOME_MESSAGE environment variable
            @Value("${WELCOME_MESSAGE}") String message){
      this.message = message;
       // this.message ="A welcome message";
    }
}
