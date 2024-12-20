package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Disc extends Media implements Playable {
    private int length = 0;
    private String director;
    public Disc() {
        super();
    }
    public void play() throws PlayerException {}
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}
