package theo.dev.manageMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theo.dev.manageMaster.entities.BillingData;
import theo.dev.manageMaster.services.BillingService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    BillingService service;

    @GetMapping("/getAll")
    public List<BillingData> getAll() {
        return service.getAll();
    }

    @GetMapping("/getBillingByAppId/{app_id}")
    public ResponseEntity<List<BillingData>> getByAppId(@PathVariable Integer app_id) {
        return service.findByAppId(app_id);
    }


    @PostMapping(value = "/add", consumes = {"application/json", "application/json;charset=UTF-8"})
    public ResponseEntity<BillingData> addBilling(@RequestBody BillingData billingData) {
        return service.addBilling(billingData);
    }
}
