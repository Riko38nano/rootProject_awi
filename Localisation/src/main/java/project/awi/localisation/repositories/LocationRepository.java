package project.awi.localisation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.awi.localisation.models.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
