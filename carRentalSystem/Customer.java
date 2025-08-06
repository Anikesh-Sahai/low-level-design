package carRentalSystem;

public class Customer {

    private final String name;
    private final String licenseNo;
    private final String contact;

    public Customer(String name, String license, String contact) {
        this.name = name;
        this.contact = contact;
        this.licenseNo = license;
    }
}