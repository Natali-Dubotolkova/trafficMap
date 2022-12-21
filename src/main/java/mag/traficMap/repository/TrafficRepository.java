package mag.traficMap.repository;

import mag.traficMap.entity.Street;
import mag.traficMap.entity.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrafficRepository extends JpaRepository<Traffic, Long> {
    List<Traffic> findByStreetId(Long streetId);

    void deleteById(Long id);

    void deleteByStreet(Street street);
}
