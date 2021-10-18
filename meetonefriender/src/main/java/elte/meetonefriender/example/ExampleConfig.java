package elte.meetonefriender.example;

import elte.meetonefriender.interest.Interest;
import elte.meetonefriender.interest.InterestRepository;
import elte.meetonefriender.person.Gender;
import elte.meetonefriender.person.Person;
import elte.meetonefriender.person.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//this file is responsible for initial values
@Configuration
public class ExampleConfig {

    @Bean
    CommandLineRunner commandLineRunner(ExampleRepository exampleRepository, InterestRepository interestRepository, PersonRepository personRepository) {
        return args -> {

            List<Example> exList = new ArrayList<>();
            exList.add(new Example("first"));
            exList.add(new Example("second"));
            exampleRepository.saveAll(exList);

            List<Interest> interestList = new ArrayList<>();
            interestList.add(new Interest("finance", "work"));
            interestList.add(new Interest("football", "ENTERTAINMENT"));
            interestList.add(new Interest("english", "LANGUAGE"));
            interestRepository.saveAll(interestList);

            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

            List<Person> personList = new ArrayList<>();
            personList.add(new Person("Jake", "Johnson", "jjohnson",
                    "12345as", dateformat.parse("01/01/1990"), Gender.MALE, "London"));
            personList.add(new Person("Tony", "Soprano", "tsoprano",
                    "12345as", dateformat.parse("01/01/1990"), Gender.MALE, "New Jersey"));
            personList.add(new Person("Jane", "Steele", "jsteele",
                    "12345as", dateformat.parse("01/01/1990"), Gender.FEMALE, "Manchester"));
            personRepository.saveAll(personList);
        };
    }
}
