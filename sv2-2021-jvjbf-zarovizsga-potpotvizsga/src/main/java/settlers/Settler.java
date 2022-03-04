package settlers;

public class Settler {

    // --- attributes ---------------------------------------------------------

    private static final int UNIT_PRICE = 500;

    private String nameOfSettler;
    private int amountOfTobacco;

    // --- constructors -------------------------------------------------------

    public Settler(String nameOfSettler, int amountOfTobacco) {
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
    }

    // --- getters and setters ------------------------------------------------

    public String getNameOfSettler() { return nameOfSettler; }
    public int getAmountOfTobacco() { return amountOfTobacco; }

    // --- public methods -----------------------------------------------------

    public int getExpectedIncome() {
        return UNIT_PRICE * amountOfTobacco;
    }
}