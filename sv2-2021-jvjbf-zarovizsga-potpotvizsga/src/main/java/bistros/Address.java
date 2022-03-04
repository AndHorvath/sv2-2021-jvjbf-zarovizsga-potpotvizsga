package bistros;

import java.util.Objects;

public class Address {

    // --- attributes ---------------------------------------------------------

    private String street;
    private int number;

    // --- constructors -------------------------------------------------------

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    // --- getters and setters ------------------------------------------------

    public String getStreet() { return street; }
    public int getNumber() { return number; }

    // --- public methods -----------------------------------------------------

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Address address = (Address) other;
        return number == address.number && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number);
    }
}