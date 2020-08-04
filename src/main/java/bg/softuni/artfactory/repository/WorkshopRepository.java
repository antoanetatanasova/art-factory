package bg.softuni.artfactory.repository;

import bg.softuni.artfactory.model.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

}
