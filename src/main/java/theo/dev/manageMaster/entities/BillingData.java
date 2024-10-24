package theo.dev.manageMaster.entities;

import jakarta.persistence.*;

@Entity
public class BillingData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String address;
    private String state;
    private String city;
    private String zipcode;
    private String taxIdNumber;
    private String discountCode;

    private Integer app_id;

    // Default constructor (needed by JPA)
    public BillingData() {
    }

    public BillingData(String address, String state, String city, String zipcode, String taxIdNumber, String discountCode, Integer app_id) {
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.taxIdNumber = taxIdNumber;
        this.discountCode = discountCode;
        this.app_id = app_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }
}
