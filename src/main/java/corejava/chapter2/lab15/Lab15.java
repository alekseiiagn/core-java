package corejava.chapter2.lab15;

import java.util.Random;

public class Lab15 {

    static final int maxUnitPrice = 50_000;
    static final int maxQuantity = 100;
    static final int maxCount = 20;

    public static Invoice createRandomInvoice() {
        Invoice invoice = new Invoice();
        Random random = new Random();
        String[] descriptions = {
                "Ball",
                "Milk",
                "Ice",
                "Phone",
                "Table",
                "Chair",
                "Lamp",
                "Bag",
                "Flag",
                "Gold",
                "Banana"
        };
        int countItems = random.nextInt(maxCount);
        for (int i = 0; i < countItems; i++) {
            invoice.addItem(descriptions[random.nextInt(descriptions.length - 1)], random.nextInt(maxQuantity), random.nextInt(maxUnitPrice));
        }
        return invoice;
    }

    public static void main(String[] args) {
        Invoice invoice = createRandomInvoice();
        invoice.addItem("Robot", 1, 5000);
        System.out.println(invoice.getItems());
        System.out.println(invoice);
    }
}
