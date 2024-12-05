package hust.soict.hedspi.aims.media;

import javax.swing.*;

public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title, int length) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank!");
        } else this.title = title;

        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive!");
        } else this.length = length;
    }
    public boolean equals(Object o) {
        if (o instanceof Track track) {
            return this.title.equals(track.title) && this.length == track.length;
        }

        return false;
    }
    public String toString() {
        return String.format("Track - %s - %d", title, length);
    }
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            JOptionPane.showMessageDialog(null, "Track cannot be displayed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank!");
        } else this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive!");
        } else this.length = length;
    }
}