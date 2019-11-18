package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

@RestController
public class WelcomeController {
  @GetMapping("/")
    public String sayHello(){
        return "hello";
    }
}
