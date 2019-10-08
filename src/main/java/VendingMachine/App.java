package VendingMachine;

import java.util.Scanner;

class App {

    public static void main(String[] args) {

        start();

    }

    public static void start() {

        Double balance = 0.0;
        Double paymentStatus = 0.0;
        int coinSelection = 0;
        Double currentPaymentStatus = 0.0;


        System.out.println("Welcome!");
        System.out.println("Menu: ");
        System.out.println();

        for (Item i : Item.values()) {
            System.out.println(i);
        }

        System.out.println();

        Scanner in = new Scanner(System.in);
        System.out.println("Select an item by entering the Code from the list: ");

        int codeSelection = in.nextInt();

        if (codeSelection == Item.BEVERAGE.getCode()) {
            balance = Item.BEVERAGE.getPrice();
        }

        if (codeSelection == Item.KITKAT.getCode()) {
            balance = Item.KITKAT.getPrice();
        }

        if (codeSelection == Item.SMOKES.getCode()) {
            balance = Item.SMOKES.getPrice();
        }

        if (codeSelection == Item.CHIPS.getCode()) {
            balance = Item.CHIPS.getPrice();
        }

        System.out.println("Chosen item price is: " + balance);

        System.out.println();

        System.out.println("Insert coins from the list below: ");

        for (Coin c : Coin.values()) {
            System.out.println("Denomimation: " + c.getDenomination() + " Code: " + c.getCode());
        }

        System.out.println();

        System.out.println("Insert coins to pay the price entering code from the list till the price is paid. " +
                "The Vending Machine returns the change");

        coinSelection = in.nextInt();

        if (coinSelection == Coin.FIVE_PLN.getCode()) {
            paymentStatus = Coin.FIVE_PLN.getDenomination();
        }

        if (coinSelection == Coin.TWO_PLN.getCode()) {
            paymentStatus = Coin.TWO_PLN.getDenomination();
        }

        if (coinSelection == Coin.ONE_PLN.getCode()) {
            paymentStatus = Coin.ONE_PLN.getDenomination();
        }

        if (coinSelection == Coin.FIFTY_GROSZE.getCode()) {
            paymentStatus = Coin.FIFTY_GROSZE.getDenomination();
        }

        if (coinSelection == Coin.TWENTY_GROSZE.getCode()) {
            paymentStatus = Coin.TWENTY_GROSZE.getDenomination();
        }

        if (coinSelection == Coin.TEN_GROSZE.getCode()) {
            paymentStatus = Coin.TEN_GROSZE.getDenomination();
        }

        if (paymentStatus > balance) {
            System.out.println("Current payment status: " + paymentStatus + " " +
                    "exceeds the price. " + (paymentStatus - balance) + " " + "will be returned after the transaction");
            System.out.println("Delivering an item ...");
            System.out.println();
            System.out.println("Returning the change ...");
        } else if (paymentStatus == balance) {
            System.out.println("Current payment status: " + paymentStatus + " " +
                    "The price is fully paid. Chosen item will be delivered immediately. ");
            System.out.println();
            System.out.println("Delivering an item ...");
            System.out.println();
            System.out.println("The change is being returned... wait.");

        } else {


            currentPaymentStatus = getFullPrice(balance, paymentStatus, in);

            if(currentPaymentStatus == balance) {
                System.out.println("The price is fully paid. Chosen item will be delivered immediately. ");
                System.out.println();
                System.out.println("Delivering an item ...");
                System.out.println();
                System.out.println("The change is being returned... wait.");
            } else {
                do {
                    currentPaymentStatus = currentPaymentStatus + getFullPrice(balance, paymentStatus, in);
                } while (currentPaymentStatus < balance);

                System.out.println(currentPaymentStatus);
            }


            System.out.println("Current payment status: " + currentPaymentStatus++);


        }
    }

    public static Double getFullPrice(Double balance, Double paymentStatus, Scanner in) {
        Double currentPaymentStatus;
        int coinSelection;
        currentPaymentStatus = paymentStatus;

        System.out.println("Current payment status: " + currentPaymentStatus + " " +
                "The price is NOT fully paid. "
                + (balance - currentPaymentStatus) + " " + "requires to be paid. Try again");

        coinSelection = in.nextInt();

        if (coinSelection == Coin.FIVE_PLN.getCode()) {
            currentPaymentStatus = currentPaymentStatus + Coin.FIVE_PLN.getDenomination();
        }

        if (coinSelection == Coin.TWO_PLN.getCode()) {
            currentPaymentStatus = currentPaymentStatus + Coin.TWO_PLN.getDenomination();
        }

        if (coinSelection == Coin.ONE_PLN.getCode()) {
            currentPaymentStatus = currentPaymentStatus + Coin.ONE_PLN.getDenomination();
        }

        if (coinSelection == Coin.FIFTY_GROSZE.getCode()) {
            currentPaymentStatus = currentPaymentStatus + Coin.FIFTY_GROSZE.getDenomination();
        }

        if (coinSelection == Coin.TWENTY_GROSZE.getCode()) {
            currentPaymentStatus = currentPaymentStatus + Coin.TWENTY_GROSZE.getDenomination();
        }

        if (coinSelection == Coin.TEN_GROSZE.getCode()) {
            currentPaymentStatus = currentPaymentStatus + Coin.TEN_GROSZE.getDenomination();

        }
        return currentPaymentStatus;
    }
}




