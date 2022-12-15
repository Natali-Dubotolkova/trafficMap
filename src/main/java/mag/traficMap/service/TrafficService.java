package mag.traficMap.service;

import mag.traficMap.model.Traffic;
import mag.traficMap.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrafficService {
    @Autowired
    private TrafficRepository trafficRepository;

    public Traffic createTraffic(Traffic traffic) {
        return trafficRepository.save(traffic);
    }

    public Traffic getTrafficById(Long trafficId) {
        Optional<Traffic> optionalTraffic = trafficRepository.findById(trafficId);
        return optionalTraffic.get();
    }

    public List<Traffic> getAllTraffic() {
        return trafficRepository.findAll();
    }

    public Traffic updateTraffic(Traffic traffic) {
        Traffic existingTraffic = trafficRepository.findById(traffic.getId()).get();
        existingTraffic.setGrade(traffic.getGrade());
        existingTraffic.setStreet(traffic.getStreet());
        existingTraffic.setStreetFrom(traffic.getStreetFrom());
        existingTraffic.setStreetTo(traffic.getStreetTo());
        return trafficRepository.save(existingTraffic);
    }

    public void deleteTraffic(Long trafficId) {
        trafficRepository.deleteById(trafficId);
    }
}