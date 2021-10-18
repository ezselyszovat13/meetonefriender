package elte.meetonefriender.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Long personId) {
        return personRepository.findById(personId);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);
        if (!exists) {
            throw new IllegalStateException("person with id " + personId + " does not exist");
        }
        personRepository.deleteById(personId);
    }


    @Transactional
    public Person updatePerson(Person person) {
        Long id = person.getId();
        return personRepository.findById(id)
                .map(tran -> personRepository.save(person))
                .orElseThrow(() -> new IllegalStateException("the person you want to update does not exist"));
    }
}
