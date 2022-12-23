package mag.traficMap.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
public class AllStreetsAndTraffics {

    String titleStreet;
    List<TrafficModelFromToGrade> trafficList;
}
