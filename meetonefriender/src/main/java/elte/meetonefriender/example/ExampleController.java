package elte.meetonefriender.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "examples")
public class ExampleController {
    private final ExampleService exampleService;

    @Autowired
    private ExampleController(ExampleService exampleService){
        this.exampleService = exampleService;
    }

    @GetMapping
    public List<Example> getExamples(){
        return exampleService.getExamples();
    }

    @PostMapping
    public void addNewExample(@RequestBody Example example){
        exampleService.addExample(example);
    }

    @DeleteMapping(path = "{exampleId}")
    public void deleteExample(@PathVariable("exampleId") Long exampleId){
        exampleService.deleteExample(exampleId);
    }

    @PutMapping(path = "{exampleId}")
    public void updateExample(@PathVariable("exampleId") Long exampleId,
                              @RequestParam(required = false) String name){
        exampleService.updateExample(exampleId,name);
    }
}
