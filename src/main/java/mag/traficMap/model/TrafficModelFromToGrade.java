package mag.traficMap.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Data
public class TrafficModelFromToGrade implements Serializable {
    private Long idTraffic;
    private String titleStreet;
    private String titleStreetFrom;
    private String titleStreetTo;
    private int grade;
}
