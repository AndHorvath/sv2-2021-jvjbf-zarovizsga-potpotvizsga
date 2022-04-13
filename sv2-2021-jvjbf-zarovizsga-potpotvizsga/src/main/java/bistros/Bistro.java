package bistros;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bistro {

    // --- attributes ---------------------------------------------------------

    private String name;
    private Address address;
    private List<MenuItem> menu;

    // --- constructors -------------------------------------------------------

    public Bistro(String name, Address address) {
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public Address getAddress() { return address; }
    public List<MenuItem> getMenu() { return menu; }

    // --- public methods -----------------------------------------------------

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public boolean hasMenuItem(String menuItemName) {
        return menu.stream().anyMatch(menuItem -> menuItem.getName().equals(menuItemName));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Bistro bistro = (Bistro) other;
        return Objects.equals(name, bistro.name) && Objects.equals(address, bistro.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}