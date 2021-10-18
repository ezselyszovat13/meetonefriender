package elte.meetonefriender.person;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>("Person added successfully", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
    }


}
