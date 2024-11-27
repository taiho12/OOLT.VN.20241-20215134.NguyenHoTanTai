package hust.soict.hedspi.aims.media;

import javax.swing.*;

public class DVD extends Disc {
    public DVD() { super(); }
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d: %.2f $", this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
    }
    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            JOptionPane.showMessageDialog(null, "DVD cannot be displayed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
