package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
    private String artist;
    private final ArrayList<Track> tracks = new ArrayList<>();
    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists!");
        } else {
            tracks.add(track);
            System.out.println("Track added!");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed!");
        } else {
            System.out.println("Track not found!");
        }
    }
    public String toString() {
        StringBuilder content = new StringBuilder(String.format("CD - %s - %s - %s - %s - %d: %.2f $", this.getTitle(), this.getCategory(), this.getDirector(), this.getArtist(), this.getLength(), this.getCost()));
        for (Track track : tracks) {
            content.append(track.toString());
        }

        return content.toString();
    }
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
    public String getArtist() {
        return artist;
    }
    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }
}
