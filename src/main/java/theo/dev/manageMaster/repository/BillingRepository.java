package theo.dev.manageMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theo.dev.manageMaster.entities.BillingData;
import java.util.List;
import java.util.Optional;


@Repository
public interface BillingRepository extends CrudRepository<BillingData, Integer> {
    @Query("SELECT b FROM BillingData b WHERE b.app_id = ?1")
    List<BillingData> findByAppId(Integer appId);
}
