package com.ass6.Borrowing;

import com.ass6.Game.Game;
import com.ass6.Game.GameServiceImp;
import com.ass6.User.User;

import java.util.*;


public class BorrowingServiceImp implements BorrowService{
    private GameServiceImp gameService;
    private Queue<Game> borrowedQueue = new LinkedList<>();
    public BorrowingServiceImp(GameServiceImp gameService) {

        this.gameService = gameService;
    }

    public Game findGameById(int id) {
        for (Game g : gameService.getAllGames()) {  // ✅ use shared list
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    @Override
    public String issueGame(int gameId, User user) {
        Game game = findGameById(gameId);

        if (user == null) {
            return "Error: User does not exist!";
        }
        if (game == null) {
            return "Error: Game not found!";
        }
        if (game.isBorrowed()) {
            return "Error: Game is already borrowed!";
        }

        // Mark game as borrowed
        game.setBorrowed(true);
        game.setBorrower(user.getUsername());

        // Add to borrowed queue and user’s borrowed list
        borrowedQueue.add(game);
        user.getBorrowedGames().add(game);

        return "Success: " + user.getUsername() + " borrowed " + game.getName();
    }

    @Override
    public String returnGame(int gameId, User user) {
        Game game = findGameById(gameId);

        if (user == null) {
            return "Error: User does not exist!";
        }
        if (game == null) {
            return "Error: Game not found!";
        }
        if (!game.isBorrowed() || !game.getBorrower().equals(user.getUsername())) {
            return "Error: Only borrower can return the game!";
        }

        // Update game status
        game.setBorrowed(false);
        game.setBorrower(null);

        // Remove from borrowedQueue and user’s borrowed list
        borrowedQueue.remove(game);
        user.getBorrowedGames().remove(game);

        return "Success: " + user.getUsername() + " returned " + game.getName();
    }

    @Override
    public void showBorrowedGamesQueue() {
        if (borrowedQueue.isEmpty()) {
            System.out.println("No games are currently borrowed.");
            return;
        }

        System.out.println("Borrowed Games Queue:");
        for (Game g : borrowedQueue) {
            System.out.println("Game ID: " + g.getId() + ", Name: " + g.getName() +
                    ", Borrower: " + g.getBorrower());
        }
    }
}
