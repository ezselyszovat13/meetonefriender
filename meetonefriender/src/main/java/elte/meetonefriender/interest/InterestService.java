package elte.meetonefriender.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InterestService {

    private InterestRepository interestRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    public List<Interest> getInterests() {
        return interestRepository.findAll();
    }

    public Optional<Interest> getInterest(Long id) {
        return interestRepository.findById(id);
    }

    public void addInterest(Interest interest) {
        System.out.println(interest.toString());
        interestRepository.save(interest);
    }

    @Transactional
    public void updateInterest(Interest interest) {
        Interest interest1 = interestRepository.findById(interest.getId()).orElseThrow(() ->
                new IllegalStateException(("This Interest does not exist")));
        interestRepository.save(interest);
    }

    public void deleteInterest(Long id) {
        interestRepository.deleteById(id);
    }

}
