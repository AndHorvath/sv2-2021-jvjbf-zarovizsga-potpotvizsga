package bistros;

public class MenuItem {

    // --- attributes ---------------------------------------------------------

    private String name;
    private int price;
    private MenuItemType type;

    // --- constructors -------------------------------------------------------

    public MenuItem(String name, int price, MenuItemType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public MenuItemType getType() { return type; }

    // --- public methods -----------------------------------------------------

    public double getPrice() {
        return price * (1 + type.getTax() / 100d);
    }
}