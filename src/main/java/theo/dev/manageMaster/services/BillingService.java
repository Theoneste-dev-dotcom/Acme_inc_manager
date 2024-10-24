package theo.dev.manageMaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.dev.manageMaster.entities.AppUser;
import theo.dev.manageMaster.entities.BillingData;
import theo.dev.manageMaster.repository.BillingRepository;
import theo.dev.manageMaster.repository.UserRepository;

import java.util.*;

@Service
public class BillingService {
    @Autowired
    BillingRepository billingRepository;
    @Autowired
    UserRepository userRepository;

    public List<BillingData> getAll() {
        List<BillingData> billings = new ArrayList<>();
        billingRepository.findAll().forEach(billings::add);
        return billings;
    }
    public ResponseEntity<List<BillingData>> findByAppId(Integer appId) {
        List<BillingData> billingData = billingRepository.findByAppId(appId);

        if (!billingData.isEmpty()) {
            return ResponseEntity.ok(billingData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no data is found
        }
    }



    public ResponseEntity<BillingData> addBilling(BillingData billingData) {
        AppUser appUser = userRepository.findById(billingData.getApp_id())
                .orElseThrow(() -> new RuntimeException("User with that id not found"));
        billingData.setAddress(billingData.getAddress());
        billingData.setState(billingData.getState());
        billingData.setCity(billingData.getCity());
        billingData.setZipcode(billingData.getZipcode());
        billingData.setTaxIdNumber(billingData.getTaxIdNumber());
        billingData.setDiscountCode(billingData.getDiscountCode());
        billingData.setApp_id(appUser.getId());

        billingRepository.save(billingData);

        return ResponseEntity.ok(billingData);
    }
}
