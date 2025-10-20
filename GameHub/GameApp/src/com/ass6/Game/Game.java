package com.ass6.Game;

public class Game implements Comparable<Game> {
    private static int counter = 1;
    private int id;
    private String name;
    private String genre;
    private int rating; // 1–5
    private String platform; // "PC" or "Console"
    private boolean borrowed;
    private String borrower;

    public Game(String name, String genre, int rating, String platform) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.id = counter++;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.platform = platform;
        this.borrowed = false;
        this.borrower = null;
    }
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Game.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", platform='" + platform + '\'' +
                ", borrowed=" + borrowed +
                ", borrower='" + borrower + '\'' +
                '}';
    }

    @Override
    public int compareTo(Game o) {
        return Integer.compare(this.id, o.id);

    }
}
