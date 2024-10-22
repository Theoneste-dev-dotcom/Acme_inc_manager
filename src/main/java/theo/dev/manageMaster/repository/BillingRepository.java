package theo.dev.manageMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import theo.dev.manageMaster.entities.BillingData;

@Repository
public interface BillingRepository extends CrudRepository<BillingData, Integer> {

}
