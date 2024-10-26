package Aims;
// Nguyễn Hồ Tấn Tài 20215134

public class Aims {
    public static void main(String[] args) {
        System.out.println(" Nguyễn Hồ Tấn Tài 20215134");
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers",  87,  50f);
        anOrder.addDigitalVideoDisc(dvd3);

        // print cart after add 3 disc
        System.out.println(" print cart after add 3 disc");
        anOrder.printAllDisc();
        // Remove the Disc "The Lion King"
        anOrder.removeDigitalVideoDisc(dvd1);
        //  print cart after remove disc "The Lion King"
        System.out.println(" print cart after remove disc The Lion King=");
        anOrder.printAllDisc();
    }
}
