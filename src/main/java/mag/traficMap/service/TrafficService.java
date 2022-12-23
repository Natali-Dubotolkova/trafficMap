package mag.traficMap.service;

import mag.traficMap.model.AllStreetsAndTraffics;
import mag.traficMap.model.TrafficModelFromToGrade;
import mag.traficMap.entity.Street;
import mag.traficMap.entity.Traffic;
import mag.traficMap.repository.StreetRepository;
import mag.traficMap.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrafficService {
    @Autowired
    private TrafficRepository trafficRepository;

    @Autowired
    private StreetRepository streetRepository;

    public Traffic createTraffic(Long id, TrafficModelFromToGrade model) {
        Traffic traffic = new Traffic();
        Street streetFrom = streetRepository.findByStreetTitle(model.getTitleStreetFrom());
        Street streetTo = streetRepository.findByStreetTitle(model.getTitleStreetTo());
        return streetRepository.findById(id).map(street -> {
            traffic.setStreet(street);
            traffic.setStreetTo(streetTo);
            traffic.setStreetFrom(streetFrom);
            traffic.setGrade(model.getGrade());
            return trafficRepository.save(traffic);
        }).orElse(null);
    }

    public Traffic getTrafficById(Long trafficId) {
        Optional<Traffic> optionalTraffic = trafficRepository.findById(trafficId);
        return optionalTraffic.get();
    }

    public List<TrafficModelFromToGrade> getAllStreetsAndTraffic(){
        List<TrafficModelFromToGrade> returnedTraffics = new ArrayList<>();
            var trafficList = trafficRepository.findAll();
            for (Traffic traffic: trafficList) {
                returnedTraffics.add(new TrafficModelFromToGrade(traffic.getId(),traffic.getStreet().getStreetTitle(),traffic.getStreetFrom().getStreetTitle(),traffic.getStreetTo().getStreetTitle(),traffic.getGrade()));
            }
        return  returnedTraffics;
    }

    public List<TrafficModelFromToGrade> getTrafficByStreetId(Long streetId) {
        if(streetRepository.existsById(streetId)) {
            var traficList = trafficRepository.findByStreetId(streetId);
            List<TrafficModelFromToGrade> returnedTraffics = new ArrayList<>();
            for (Traffic traffic: traficList) {
                returnedTraffics.add(new TrafficModelFromToGrade(traffic.getId(), traffic.getStreet().getStreetTitle(),traffic.getStreetFrom().getStreetTitle(), traffic.getStreetTo().getStreetTitle(),traffic.getGrade()));
            }
            return  returnedTraffics;
        }
        else {
            return null;
        }
    };
    public List<Traffic> getAllTraffic() {
        return trafficRepository.findAll();
    }

    public void deleteTraffic(Long trafficId) {
        trafficRepository.deleteById(trafficId);
    }

    public void deleteTrafficByStreet(Street street) {trafficRepository.deleteByStreet(street);}
}