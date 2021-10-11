package elte.meetonefriender.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//this file is responsible for initial values
@Configuration
public class ExampleConfig {

    @Bean
    CommandLineRunner commandLineRunner(ExampleRepository exampleRepository){
        return args -> {
            List<Example> exList = new ArrayList<>();
            exList.add(new Example("first"));
            exList.add(new Example("second"));
            exampleRepository.saveAll(exList);
        };
    }
}
