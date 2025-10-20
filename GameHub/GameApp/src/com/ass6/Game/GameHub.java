package com.ass6.Game;

import com.ass6.Report.ReportServiceImp;
import com.ass6.User.UserServiceImp;
import com.ass6.Borrowing.BorrowingServiceImp;
import com.ass6.User.User;

import java.util.Scanner;

public class GameHub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameServiceImp gm = new GameServiceImp();
        UserServiceImp um = new UserServiceImp();
        BorrowingServiceImp bm = new BorrowingServiceImp(gm);
        ReportServiceImp report = new ReportServiceImp(gm, um, bm);
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Game Management");
            System.out.println("2. User Management");
            System.out.println("3. Borrow/Return Games");
            System.out.println("4. View Borrowed Games Queue");
            System.out.println("5. Reports & Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1: // Game Management
                    System.out.println("\n===== GAME MANAGEMENT =====");
                    System.out.println("1. Add Game");
                    System.out.println("2. Remove Game");
                    System.out.println("3. View Games");
                    System.out.println("4. Search Game");
                    System.out.print("Enter your choice: ");
                    int gameChoice = sc.nextInt();
                    sc.nextLine();

                    switch (gameChoice) {
                        case 1: gm.addGame(); break;
                        case 2:
                            System.out.print("Enter Game ID to remove: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            gm.removeGame(id);
                            break;
                        case 3:
                            System.out.println("View Options: id / name / rating / availability");
                            System.out.print("Enter option: ");
                            String sortBy = sc.nextLine();
                            gm.viewGames(sortBy);
                            break;
                        case 4:
                            System.out.print("Enter Name or Genre to search: ");
                            String keyword = sc.nextLine();
                            gm.searchGame(keyword);
                            break;
                        default: System.out.println("Invalid choice in Game Management.");
                    }
                    break;

                case 2: // User Management
                    System.out.println("\n===== USER MANAGEMENT =====");
                    System.out.println("1. Register User");
                    System.out.println("2. View Users");
                    System.out.print("Enter your choice: ");
                    int userChoice = sc.nextInt();
                    sc.nextLine();

                    switch (userChoice) {
                        case 1: um.registerUser(); break;
                        case 2: um.viewUsers(); break;
                        default: System.out.println("Invalid choice in User Management.");
                    }
                    break;

                case 3: // Borrow/Return Games
                    System.out.println("\n===== BORROW/RETURN GAMES =====");
                    System.out.println("1. Borrow Game (User Story 2)");
                    System.out.println("2. Return Game (User Story 3)");
                    System.out.print("Enter your choice: ");
                    int borrowChoice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter your username: ");
                    String username = sc.nextLine();
                    User user = um.findUserByUsername(username);

                    switch (borrowChoice) {
                        case 1:
                            System.out.print("Enter Game ID to borrow: ");
                            int borrowGameId = sc.nextInt();
                            sc.nextLine();

                            // User Story 2 acceptance criteria
                            if (user == null) {
                                System.out.println("Error: User must be registered!");
                            } else {
                                System.out.println(bm.issueGame(borrowGameId, user));
                            }
                            break;

                        case 2:
                            System.out.print("Enter Game ID to return: ");
                            int returnGameId = sc.nextInt();
                            sc.nextLine();

                            // User Story 3 acceptance criteria
                            if (user == null) {
                                System.out.println("Error: User must be registered!");
                            } else {
                                System.out.println(bm.returnGame(returnGameId, user));
                            }
                            break;

                        default:
                            System.out.println("Invalid choice in Borrow/Return menu.");
                    }
                    break;

                case 4: // View borrowed games queue
                    bm.showBorrowedGamesQueue();
                    break;
                case 5: // Reports & Statistics
                    System.out.println("\n===== REPORTS & STATISTICS =====");
                    System.out.println("1. Collection Statistics");
                    System.out.println("2. User Statistics");
                    System.out.println("3. Borrowed Games Queue");
                    System.out.print("Enter your choice: ");
                    int reportChoice = sc.nextInt();
                    sc.nextLine();

                    switch (reportChoice) {
                        case 1: report.showCollectionStats(); break;
                        case 2: report.showUserStats(); break;
                        case 3: report.showBorrowedQueue(); break;
                        default: System.out.println("Invalid choice in Reports & Statistics.");
                    }
                    break;                case 6: // Exit
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid main menu choice! Try again.");
            }
        }
    }
}
