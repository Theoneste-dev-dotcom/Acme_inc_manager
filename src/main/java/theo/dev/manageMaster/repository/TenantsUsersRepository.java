package theo.dev.manageMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theo.dev.manageMaster.entities.TenantsUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenantsUsersRepository extends CrudRepository<TenantsUser, Integer> {
//    Optional<TenantsUser> findById(Integer id);
    List<TenantsUser> findByOwnerId(long id);
    List<TenantsUser> findByOwnerId(Long ownerId);
    List<TenantsUser> findByPermissions(String permission);
    List<TenantsUser> findByRole(String role);
     TenantsUser findByEmail(String email);


}
