package com.ass6.User;

import com.ass6.Game.Game;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private List<Game> borrowedGames = new ArrayList<>();

    public List<Game> getBorrowedGames() {
        return borrowedGames;
    }

    public void setBorrowedGames(List<Game> borrowedGames) {
        this.borrowedGames = borrowedGames;
    }



    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", borrowedGames=" + borrowedGames +
                '}';
    }
}

