package com.ass6.Game;

import java.util.*;
import java.util.Scanner;

public class GameServiceImp implements GameService{
    private List<Game> allGames = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    @Override
    public void addGame() {
        System.out.print("Enter Game Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        int rating;
        while (true) {
            System.out.print("Enter Rating (1-5): ");
            rating = sc.nextInt();
            sc.nextLine(); // consume newline
            if (rating >= 1 && rating <= 5) break;
            System.out.println("Invalid rating! Please enter between 1 and 5.");
        }

        System.out.print("Enter Platform (PC/Console): ");
        String platform = sc.nextLine();

        Game g = new Game(name, genre, rating, platform);
        allGames.add(g);

        System.out.println("Game added successfully! ID = " + g.getId());
    }

    @Override
    public void viewGames(String sortBy) {
        List<Game> sorted = new ArrayList<>(allGames);

        switch (sortBy.toLowerCase()) {
            case "name": sorted.sort(Comparator.comparing(Game::getName)); break;
            case "rating": sorted.sort(Comparator.comparing(Game::getRating).reversed()); break;
            default: Collections.sort(sorted); // by ID
        }

        for (Game g : sorted) {
            System.out.println(g);
        }
    }

    @Override
    public void removeGame(int id) {
        for (Game g : allGames) {
            if (g.getId() == id) {
                if (g.isBorrowed()) {
                    System.out.println("Cannot remove. Game is currently borrowed.");
                    return;
                }
                allGames.remove(g);
                System.out.println("Game removed successfully!");
                return;
            }
        }
        System.out.println("Game not found!");

    }

    @Override
    public void searchGame(String keyword) {
        boolean found = false;
        for (Game g : allGames) {
            if (g.getName().equalsIgnoreCase(keyword) || g.getGenre().equalsIgnoreCase(keyword)) {
                System.out.println(g);
                found = true;
            }
        }
        if (!found) System.out.println("No matching games found!");
    }
    public List<Game> getAllGames() {
        return allGames;
    }
}
