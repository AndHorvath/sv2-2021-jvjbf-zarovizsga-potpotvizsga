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
        return type == MenuItemType.FOOD ? price * 1.2 : price * 1.27;
    }
}