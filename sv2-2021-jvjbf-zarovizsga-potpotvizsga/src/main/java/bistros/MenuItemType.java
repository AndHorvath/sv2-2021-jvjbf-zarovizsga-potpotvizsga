package bistros;

public enum MenuItemType {

    FOOD(20), DRINK(27);

    // --- attributes ---------------------------------------------------------

    private final int tax;

    // --- constructors -------------------------------------------------------

    MenuItemType(int tax) {
        this.tax = tax;
    }

    // --- getters and setters ------------------------------------------------

    public int getTax() { return tax; }
}