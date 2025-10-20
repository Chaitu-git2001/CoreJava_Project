package com.ass6.User;

import java.util.*;
import java.util.Scanner;

public class UserServiceImp implements UserService{

    private Map<String, User> users = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void registerUser() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("❌ Error: Username already exists!");
            return;
        }

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        User user = new User(username, email);
        users.put(username, user);
        System.out.println("✅ User registered successfully: " + username);

    }

    @Override
    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }
        System.out.println("\n=== Registered Users ===");
        for (User u : users.values()) {
            System.out.println(u);
        }
    }

    public User findUserByUsername(String username) {
        return users.get(username); // Returns null if user doesn't exist
    }
    public Collection<User> getAllUsers() {
        return users.values();
    }
}
