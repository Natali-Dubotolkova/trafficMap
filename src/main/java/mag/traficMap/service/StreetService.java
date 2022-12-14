package mag.traficMap.service;

import mag.traficMap.model.Street;
import mag.traficMap.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public Street createStreet(Street street) {
        return streetRepository.save(street);
    }

    public Street getStreetById(Long userId) {
        Optional<Street> optionalStreet = streetRepository.findById(userId);
        return optionalStreet.get();
    }

    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }

    public Street updateStreet(Street street) {
        Street existingStreet = streetRepository.findById(street.getId()).get();
        existingStreet.setStreetTitle(street.getStreetTitle());
        return streetRepository.save(existingStreet);
    }

    public void deleteStreet(Long streetId) {
        streetRepository.deleteById(streetId);
    }
}
