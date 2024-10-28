package main;

import model.Cart;
import model.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);

        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                "George Lucas", 87, 24.95f);

        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
                18.99f);

        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        for (int i = 0; i < anOrder.getItemsOrdered().size(); i++) {
            DigitalVideoDisc disc = anOrder.getItemsOrdered().get(i);
            System.out.println("Disc: " + disc.getTitle() + ", Cost: " + disc.getCost());
        }

        anOrder.removeDigitalVideoDisc(dvd3);

        for (int i = 0; i < anOrder.getItemsOrdered().size(); i++) {
            DigitalVideoDisc disc = anOrder.getItemsOrdered().get(i);
            System.out.println("Disc: " + disc.getTitle() + ", Cost: " + disc.getCost());
        }
    }
}