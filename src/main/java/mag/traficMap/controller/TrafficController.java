package mag.traficMap.controller;

import mag.traficMap.model.AllStreetsAndTraffics;
import mag.traficMap.model.TrafficModelFromToGrade;
import mag.traficMap.entity.Traffic;
import mag.traficMap.service.StreetService;
import mag.traficMap.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins= {"http://localhost:8081"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/street")
public class TrafficController {
    @Autowired
    TrafficService trafficService;
    @Autowired
    StreetService streetService;

    @GetMapping("/{streetId}/allTraffic")
    public ResponseEntity<List<TrafficModelFromToGrade>> getAllTrafficByStreetId(@PathVariable(value = "streetId") Long streetId){
        return new ResponseEntity<>(trafficService.getTrafficByStreetId(streetId), HttpStatus.OK) ;
    };

    @PostMapping("/{streetId}/traffic")
    public ResponseEntity<Traffic> createTraffic(@PathVariable(value = "streetId") Long streetId,
                                                 @RequestBody TrafficModelFromToGrade model){
        return new ResponseEntity<>(trafficService.createTraffic(streetId, model),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TrafficModelFromToGrade>> getAllInfo(){
        return new ResponseEntity<>(trafficService.getAllStreetsAndTraffic(),HttpStatus.OK);
    }
}
