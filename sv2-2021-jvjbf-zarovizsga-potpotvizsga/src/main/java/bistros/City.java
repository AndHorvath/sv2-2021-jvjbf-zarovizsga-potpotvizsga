package bistros;

import java.util.*;

public class City {

    // --- attributes ---------------------------------------------------------

    private Set<Bistro> bistros;

    // --- constructors -------------------------------------------------------

    public City() {
        bistros = new LinkedHashSet<>();
    }

    // --- getters and setters ------------------------------------------------

    public Set<Bistro> getBistros() { return bistros; }

    // --- public methods -----------------------------------------------------

    public void addBistro(Bistro bistro) {
        bistros.add(bistro);
    }

    public Bistro findBistroByAddress(Address address) {
        return bistros.stream()
            .filter(bistro -> bistro.getAddress().equals(address))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("No bistro on specified address."));
    }

    public Bistro findLongestMenu() {
        return bistros.stream()
            .max(Comparator.comparingInt(bistro -> bistro.getMenu().size()))
            .orElseThrow(() -> new IllegalArgumentException("No bistros in the city."));
    }

    public List<Bistro> findBistroWithMenuItem(String menuItemName) {
        return bistros.stream()
            .filter(
                bistro ->
                bistro.getMenu().stream().anyMatch(menuItem -> menuItem.getName().equals(menuItemName)))
            .toList();
    }


}