package mag.traficMap.repository;

import mag.traficMap.model.Street;
import mag.traficMap.model.Traffic;
import mag.traficMap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrafficRepository extends JpaRepository<Traffic, Long> {
    Optional<Traffic> findAllByStreet(Street street);
}
