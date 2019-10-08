package VendingMachine;

enum Item {

    BEVERAGE(1.6, 1),
    KITKAT(1.8, 2),
    SMOKES(2.1, 3),
    CHIPS(1.9, 4);

    private double price;
    private int code;

    Item(double price, int code) {
        this.price = price;
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "price: " + price +
                ", code: " + code;
    }
}
