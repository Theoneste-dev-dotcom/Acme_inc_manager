package theo.dev.manageMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import theo.dev.manageMaster.dtos.ImageData;
import theo.dev.manageMaster.entities.AppUser;

@Repository
public interface ImageRepository extends JpaRepository<ImageData, Integer> {
   ImageData findByOwnerId(Integer ownerId);
}
