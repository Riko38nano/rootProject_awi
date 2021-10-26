package project.awi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.awi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
