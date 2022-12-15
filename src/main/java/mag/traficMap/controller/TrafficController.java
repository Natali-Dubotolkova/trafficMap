package mag.traficMap.controller;

import mag.traficMap.model.Traffic;
import mag.traficMap.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traffic")
public class TrafficController {
    @Autowired
    TrafficService trafficService;

    // build create Street REST API
    @PostMapping
    public ResponseEntity<Traffic> createTraffic(@RequestBody Traffic traffic){
        Traffic savedUser = trafficService.createTraffic(traffic);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/traffic/1
    @GetMapping("{id}")
    public ResponseEntity<Traffic> getTrafficById(@PathVariable("id") Long trafficId){
        Traffic traffic = trafficService.getTrafficById(trafficId);
        return new ResponseEntity<>(traffic, HttpStatus.OK);
    }

    // Build Get All Streets REST API
    // http://localhost:8080/api/traffic
    @GetMapping
    public ResponseEntity<List<Traffic>> getAllTraffic(){
        List<Traffic> traffics = trafficService.getAllTraffic();
        return new ResponseEntity<>(traffics, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/traffic/1
    public ResponseEntity<Traffic> updateTraffic(@PathVariable("id") Long trafficId,
                                               @RequestBody Traffic traffic){
        traffic.setId(traffic.getId());
        Traffic updatedStreet = trafficService.updateTraffic(traffic);
        return new ResponseEntity<>(updatedStreet, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTraffic(@PathVariable("id") Long trafficId){
        trafficService.deleteTraffic(trafficId);
        return new ResponseEntity<>("Traffic successfully deleted!", HttpStatus.OK);
    }
}
