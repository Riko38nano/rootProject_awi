package project.awi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.awi.models.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
