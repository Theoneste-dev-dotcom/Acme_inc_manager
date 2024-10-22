package theo.dev.manageMaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theo.dev.manageMaster.entities.BillingData;
import theo.dev.manageMaster.repository.BillingRepository;
import java.util.*;

@Service
public class BillingService {
    @Autowired
    BillingRepository billingRepository;


    public List<BillingData> getAll() {
        List<BillingData> billings  = new ArrayList<>();
       billingRepository.findAll().forEach(billings::add);
        return billings;
    }
   public String addBilling(BillingData billingData) {
     billingRepository.save(billingData);
     return "Billing added successfully";
   }
}
