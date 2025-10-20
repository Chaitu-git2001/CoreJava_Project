package com.ass6.Report;

import com.ass6.Borrowing.BorrowingServiceImp;
import com.ass6.Game.Game;
import com.ass6.Game.GameServiceImp;
import com.ass6.User.UserServiceImp;

public class ReportServiceImp implements ReportService{
    private GameServiceImp gameService;
    private UserServiceImp userService;
    private BorrowingServiceImp borrowService;

    public ReportServiceImp(GameServiceImp gm, UserServiceImp um, BorrowingServiceImp bm) {
        this.gameService = gm;
        this.userService = um;
        this.borrowService = bm;
    }

    // Collection Statistics
    public void showCollectionStats() {
        int totalGames = gameService.getAllGames().size();
        long borrowedGames = gameService.getAllGames().stream().filter(Game::isBorrowed).count();
        long availableGames = totalGames - borrowedGames;

        System.out.println("\n=== Collection Statistics ===");
        System.out.println("Total Games       : " + totalGames);
        System.out.println("Available Games   : " + availableGames);
        System.out.println("Borrowed Games    : " + borrowedGames);
    }

    // User Statistics
    public void showUserStats() {
        int totalUsers = userService.getAllUsers().size();

        System.out.println("\n=== User Statistics ===");
        System.out.println("Total Registered Users: " + totalUsers);
    }

    // Borrowed Queue Display
    public void showBorrowedQueue() {
        System.out.println("\n=== Current Borrowed Games ===");
        borrowService.showBorrowedGamesQueue();
    }
}
