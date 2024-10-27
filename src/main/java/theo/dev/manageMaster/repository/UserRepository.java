package theo.dev.manageMaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theo.dev.manageMaster.entities.AppUser;

import java.util.Optional;

@Repository
    public interface UserRepository extends CrudRepository<AppUser, Integer> {

        Optional<AppUser> findByEmail(String email);
    }

