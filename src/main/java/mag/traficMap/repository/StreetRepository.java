package mag.traficMap.repository;

import mag.traficMap.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreetRepository extends JpaRepository<Street, Long> {
    Optional<Street> findByStreetTitle(String title);
}
