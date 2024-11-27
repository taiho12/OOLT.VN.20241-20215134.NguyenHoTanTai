package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media already exists!");
        } else {
            itemsInStore.add(media);
            System.out.println("Media added!");
        }
    }
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media removed!");
        } else {
            System.out.println("Media not found!");
        }
    }
    public Media searchMedia(String title) {
        for (Media media : itemsInStore)
            if (media.getTitle().equals(title)) return media;

        return null;
    }
    public void print() {
        for (int i = 0; i < itemsInStore.size(); i++)
            System.out.printf("%d. %s%n", i + 1, itemsInStore.get(i).toString());
    }
}
