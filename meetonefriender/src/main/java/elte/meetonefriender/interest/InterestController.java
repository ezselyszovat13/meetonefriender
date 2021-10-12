package elte.meetonefriender.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "interest")
public class InterestController {

    private final InterestService interestService;

    @Autowired
    public InterestController(InterestService interestService) {
        this.interestService = interestService;
    }

    @GetMapping
    public List<Interest> getInterests() {
        return interestService.getInterests();
    }

    @PostMapping
    public ResponseEntity<String> addInterest(@RequestBody Interest interest) {
        interestService.addInterest(interest);
        return new ResponseEntity<>("Interest Added Successfully", HttpStatus.OK);

    }

    @GetMapping("{id}")
    public Interest getInterest(@PathVariable Long id) {
        return interestService.getInterest(id).orElse(null);
    }

    @PutMapping("{id}")
    public ResponseEntity<String>  updateInterest(@RequestBody Interest newInterest, @PathVariable Long id) {
        interestService.getInterest(id)
                .map(interest -> {
                    interest.setInterestType(newInterest.getInterestType());
                    interest.setName(newInterest.getName());
                     interestService.addInterest(interest);
                    return null;
                }).orElseGet(() -> {
                    newInterest.setId(id);
                    interestService.addInterest(newInterest);
                    return null;
                });
        return new ResponseEntity<>("Interest Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInterest(@PathVariable Long id) {
        interestService.deleteInterest(id);
        return new ResponseEntity<>("Interest Deleted Successfully", HttpStatus.OK);
    }



}
