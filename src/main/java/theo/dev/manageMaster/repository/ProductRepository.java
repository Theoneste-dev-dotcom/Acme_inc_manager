package theo.dev.manageMaster.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import theo.dev.manageMaster.entities.Product;
import theo.dev.manageMaster.entities.TenantsUser;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByOwnerId(Long ownerId);
    // Additional query methods (if needed) can be defined here.
}
