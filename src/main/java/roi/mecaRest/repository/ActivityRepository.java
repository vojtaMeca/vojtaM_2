package roi.mecaRest.repository;

import roi.mecaRest.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import roi.mecaRest.model.User;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.Set;

public interface ActivityRepository extends JpaRepository<Activity, Long>{

    Collection<Activity> findActivitiesByUsers(Set<User> users);
}
