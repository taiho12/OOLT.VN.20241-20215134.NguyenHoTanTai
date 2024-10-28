package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    public List<DigitalVideoDisc> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(disc);
            System.out.println("The disc has been added");
            if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            }
        } else {
            System.out.println("The cart is full. Can not add anymore");
        }
    }

    public void removeDigitalVideoDisc (DigitalVideoDisc disc){
        if (itemsOrdered.remove(disc)) {
            System.out.println("The disc has been removed");
        } else {
            System.out.println("Cannot found the disc");
        }
    }

    public float totalCost() {
        float TotalCost = 0;
        for (DigitalVideoDisc disc : itemsOrdered) {
            TotalCost += disc.getCost();
        }
        return TotalCost;
    }
}
