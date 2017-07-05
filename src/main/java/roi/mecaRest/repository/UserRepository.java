package roi.mecaRest.repository;

import roi.mecaRest.model.Activity;
import roi.mecaRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer>{
    Collection<User> findByActivities(Set<Activity> activities);

    Optional<User> findByIdEquals(int id);


    default Optional<User> findByGoogle_id(String google_id) {
        return null;
    }
}
