package mag.traficMap.repository;

import mag.traficMap.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
    Street findByStreetTitle(String title);
}
