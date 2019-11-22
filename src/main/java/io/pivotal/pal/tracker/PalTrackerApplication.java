package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @ComponentScan(basePackages = {"io.pivotal.pal.tracker"})
public class PalTrackerApplication {

    @Bean
    TimeEntryRepository timeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    };


    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);


    }
}
