package VendingMachine;

enum Coin {

    FIVE_PLN(5.0, 1),
    TWO_PLN(2.0, 2),
    ONE_PLN(1.0, 3),
    FIFTY_GROSZE(0.5, 4),
    TWENTY_GROSZE(0.2, 5),
    TEN_GROSZE(0.1, 6);

    private Double denomination;
    private int code;

    Coin(double denomination, int code) {
        this.denomination = denomination;
        this.code = code;
    }

    @Override
    public String toString() {
        return super.toString()+ " " +
                "denomination: " + denomination +
                ", value: " + code;
    }

    public Double getDenomination() {
        return denomination;
    }

    public int getCode() {
        return code;
    }
}
