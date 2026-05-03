package com.nt;
import java.util.*;

// -------- USER CLASS --------
class User {
    String username;
    String password;
    boolean hasVoted;

    User(String username, String password) {
        this.username = username;
        this.password = password;
        this.hasVoted = false;
    }
}

public class OnlineVotingSystem {

    static Scanner sc = new Scanner(System.in);

    // Store users
    static HashMap<String, User> users = new HashMap<>();

    // Store votes
    static HashMap<String, Integer> candidates = new HashMap<>();

    public static void main(String[] args) {

        // Default candidates
        candidates.put("Alice", 0);
        candidates.put("Bob", 0);
        candidates.put("Charlie", 0);

        int choice;

        do {
            System.out.println("\n===== ONLINE VOTING SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login & Vote");
            System.out.println("3. Admin - View Results");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: register(); break;
                case 2: loginAndVote(); break;
                case 3: showResults(); break;
                case 4: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    // -------- REGISTER --------
    static void register() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        users.put(username, new User(username, password));

        System.out.println("Registration Successful!");
    }

    // -------- LOGIN & VOTE --------
    static void loginAndVote() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!users.containsKey(username) ||
            !users.get(username).password.equals(password)) {

            System.out.println("Invalid Login!");
            return;
        }

        User user = users.get(username);

        if (user.hasVoted) {
            System.out.println("You have already voted!");
            return;
        }

        // Show candidates
        System.out.println("\nCandidates:");
        for (String name : candidates.keySet()) {
            System.out.println("- " + name);
        }

        System.out.print("Enter your vote: ");
        String vote = sc.nextLine();

        if (candidates.containsKey(vote)) {

            // Increase vote count
            candidates.put(vote, candidates.get(vote) + 1);

            user.hasVoted = true;

            System.out.println("Vote cast successfully!");

        } else {
            System.out.println("Invalid candidate!");
        }
    }

    // -------- RESULTS --------
    static void showResults() {

        System.out.print("Enter Admin Password: ");
        String admin = sc.nextLine();

        if (!admin.equals("admin123")) {
            System.out.println("Access Denied!");
            return;
        }

        System.out.println("\n===== RESULTS =====");

        String winner = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());

            if (entry.getValue() > max) {
                max = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("Winner: " + winner);
    }
}
