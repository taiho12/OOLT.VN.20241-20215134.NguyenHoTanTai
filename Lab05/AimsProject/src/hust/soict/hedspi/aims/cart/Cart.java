package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public float totalCost = 0;
    public boolean addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Media already exists!");
            return false;
        } else {
            itemsOrdered.add(media);
            System.out.println("Media added to cart!");
            return true;
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media removed!");
        } else {
            System.out.println("Media not found!");
        }
    }
    public Media searchMedia(String title) {
        for (Media media : itemsOrdered)
            if (media.getTitle().equals(title)) return media;

        return null;
    }
    public float calculateCost() {
        float total_cost = 0;
        for (Media media : itemsOrdered) {
            total_cost += media.getCost();
        }

        return total_cost;
    }
    public void print() {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, itemsOrdered.get(i).toString());
        }
    }
    public List<Media> filterMedia(String title) {
        List<Media> filteredMedia = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                filteredMedia.add(media);
            }
        }

        return filteredMedia;
    }

    public List<Media> filterMedia(int id) {
        List<Media> filteredMedia = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                filteredMedia.add(media);
            }
        }

        return filteredMedia;
    }
    public float getTotalCost() {
        return this.totalCost;
    }
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
