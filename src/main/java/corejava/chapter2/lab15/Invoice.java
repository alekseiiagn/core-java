package corejava.chapter2.lab15;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private final List<Item> items = new ArrayList<>();

    private static class Item { // Класс Item вложен в класс Invoice
        String description;
        int quantity;
        double unitPrice;

        double price() {
            return quantity * unitPrice;
        }

        @Override
        public String toString() {
            return "{description: '" + description + '\'' +
                    ", quantity: " + quantity +
                    ", unitPrice: " + unitPrice +
                    ", price: " + price() +
                    '}';
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public double allPrice() {
        double result = 0;
        for (Item it : items) {
            result += it.price();
        }
        return result;
    }

    public Item getItem(int i) {
        if (i >= 0 && i < items.size()) {
            return items.get(i);
        }
        throw new ArrayIndexOutOfBoundsException("Invalid index");
    }

    public void addItem(String description, int quantity, double unitPrice) {
        Item newItem = new Item();
        newItem.description = description;
        newItem.quantity = quantity;
        newItem.unitPrice = unitPrice;
        items.add(newItem);
    }

    @Override
    public String toString() {
        return "{items: " + items +
                '}';
    }
}
