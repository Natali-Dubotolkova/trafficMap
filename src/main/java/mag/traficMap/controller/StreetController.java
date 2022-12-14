package mag.traficMap.controller;

import mag.traficMap.model.Street;
import mag.traficMap.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/street")
public class StreetController {

    @Autowired
    StreetService streetService;

    // build create Street REST API
    @PostMapping
    public ResponseEntity<Street> createStreet(@RequestBody Street street){
        Street savedUser = streetService.createStreet(street);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/street/1
    @GetMapping("{id}")
    public ResponseEntity<Street> getStreetById(@PathVariable("id") Long streetId){
        Street street = streetService.getStreetById(streetId);
        return new ResponseEntity<>(street, HttpStatus.OK);
    }

    // Build Get All Streets REST API
    // http://localhost:8080/api/street
    @GetMapping
    public ResponseEntity<List<Street>> getAllStreets(){
        List<Street> streets = streetService.getAllStreets();
        return new ResponseEntity<>(streets, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/street/1
    public ResponseEntity<Street> updateStreet(@PathVariable("id") Long streetId,
                                           @RequestBody Street street){
        street.setId(street.getId());
        Street updatedStreet = streetService.updateStreet(street);
        return new ResponseEntity<>(updatedStreet, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStreet(@PathVariable("id") Long streetId){
        streetService.deleteStreet(streetId);
        return new ResponseEntity<>("Street successfully deleted!", HttpStatus.OK);
    }
}
