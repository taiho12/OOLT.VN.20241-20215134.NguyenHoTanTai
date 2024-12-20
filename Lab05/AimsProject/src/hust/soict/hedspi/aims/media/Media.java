package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() { super(); }

    public boolean equals(Object o) {
        try {
            if (o instanceof Media media)
                return title.equals(media.title) && cost == media.cost;

            return false;
        } catch (NullPointerException | ClassCastException e) {
            e.printStackTrace();

            return false;
        }
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator.comparing(Media::getTitle)
            .thenComparing(Media::getCost);
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator.comparing(Media::getCost)
            .thenComparing(Media::getTitle);
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost must be positive!");
        } else this.cost = cost;
    }
}
