package bistros;

public class Bar extends Bistro {

    // --- constructors -------------------------------------------------------

    public Bar(String name, Address address) {
        super(name, address);
    }

    // --- public methods -----------------------------------------------------

    @Override
    public String getName() {
        return super.getName() + " (Only Drinks)";
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        validateParameter(menuItem);
        super.addMenuItem(menuItem);
    }

    // --- private methods ----------------------------------------------------

    private void validateParameter(MenuItem menuItem) {
        if (menuItem.getType() != MenuItemType.DRINK) {
            throw new IllegalArgumentException("Only drink can be added to menu!");
        }
    }
}