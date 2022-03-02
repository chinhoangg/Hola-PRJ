package model;

/**
 *
 * @author chinhoag
 */
public class Employee {
    private Name name;
    private Address address;

    public Employee() {
    }

    public Employee(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}
