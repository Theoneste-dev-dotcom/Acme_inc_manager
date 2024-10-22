package theo.dev.manageMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import theo.dev.manageMaster.entities.BillingData;
import theo.dev.manageMaster.services.BillingService;

import java.util.List;


@RestController
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    BillingService service;

    @GetMapping("/getAll")
    public List<BillingData> getAll() {
        return service.getAll();
    }


    @PostMapping("/add")
    public String addBilling(@RequestBody BillingData billingData) {
        return service.addBilling(billingData);
    }
}
