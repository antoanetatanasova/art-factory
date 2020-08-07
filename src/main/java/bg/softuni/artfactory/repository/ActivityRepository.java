package bg.softuni.artfactory.repository;

import bg.softuni.artfactory.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Activity findFirstById(Long id);

}
