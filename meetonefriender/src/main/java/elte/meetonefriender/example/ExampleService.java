package elte.meetonefriender.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ExampleService {
    private ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public List<Example> getExamples(){
        return exampleRepository.findAll();
    }

    public void addExample(Example example) {
        exampleRepository.save(example);
    }

    public void deleteExample(Long id) {
        boolean exists = exampleRepository.existsById(id);
        if(!exists)
            throw new IllegalStateException("The example you are looking for does not exists!");
        exampleRepository.deleteById(id);
    }

    @Transactional
    public void updateExample(Long exampleId, String name) {
        Example example = exampleRepository.findById(exampleId).orElseThrow(()->
                new IllegalStateException("The example you'd like to update does not exists")
        );
        if(name!=null && name.length()>0 && !Objects.equals(example.getName(),name))
            example.setName(name);
    }
}