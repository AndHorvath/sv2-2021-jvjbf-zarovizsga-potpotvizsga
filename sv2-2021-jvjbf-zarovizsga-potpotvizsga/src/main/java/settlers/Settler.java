package settlers;

public class Settler {

    // --- attributes ---------------------------------------------------------

    private long id;
    private String nameOfSettler;
    private int amountOfTobacco;

    public static final int UNIT_PRICE = 500;

    // --- constructors -------------------------------------------------------

    public Settler(String nameOfSettler, int amountOfTobacco) {
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
    }

    // --- getters and setters ------------------------------------------------

    public long getId() { return id; }
    public String getNameOfSettler() { return nameOfSettler; }
    public int getAmountOfTobacco() { return amountOfTobacco; }

    public void setId(long id) { this.id = id;}

    // --- public methods -----------------------------------------------------

    public int getExpectedIncome() {
        return UNIT_PRICE * amountOfTobacco;
    }
}