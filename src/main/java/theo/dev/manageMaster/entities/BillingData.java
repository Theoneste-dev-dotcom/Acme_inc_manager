package theo.dev.manageMaster.entities;

import jakarta.persistence.*;

@Entity
public class BillingData{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String address;
    private String state;
    private String zipcode;
    private String taxIdNumber;
    private String discountCode;

    @OneToOne
    @JoinColumn(name = "appUser_id")
    private AppUser appUser;
 public BillingData() {};

    public BillingData(String address, String state, String zipcode, String taxIdNumber, String discountCode) {
        this.address = address;
        this.state = state;
        this.zipcode = zipcode;
        this.taxIdNumber = taxIdNumber;
        this.discountCode = discountCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
    public AppUser getAppUser() {
        return appUser;
    }
    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
