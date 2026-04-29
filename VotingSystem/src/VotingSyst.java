import java.util.*;
import java.io.*;

// ----------- VOTER CLASS -----------
class Voter {
    private String name;
    private boolean hasVoted;

    public Voter(String name) {
        this.name = name;
        this.hasVoted = false;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setVoted(boolean status) {
        this.hasVoted = status;
    }
}

// ----------- CANDIDATE CLASS -----------
class Candidate {
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }
}

// ----------- MAIN CLASS -----------
public class VotingSyst {

    static Map<String, Voter> voters = new HashMap<>();
    static Map<String, Candidate> candidates = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialize candidates
        candidates.put("Alice", new Candidate("Alice"));
        candidates.put("Bob", new Candidate("Bob"));

        while (true) {
            System.out.println("\n===== ONLINE VOTING SYSTEM =====");
            System.out.println("1. Vote");
            System.out.println("2. Show Results");
            System.out.println("3. Save Results to File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    vote(sc);
                    break;

                case 2:
                    showResults();
                    break;

                case 3:
                    saveResults();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ----------- VOTING LOGIC -----------
    public static void vote(Scanner sc) {
        try {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            Voter voter = voters.getOrDefault(name, new Voter(name));

            if (voter.hasVoted()) {
                throw new Exception("You already voted!");
            }

            System.out.println("Candidates: " + candidates.keySet());
            System.out.print("Enter candidate name: ");
            String candidateName = sc.nextLine();

            if (!candidates.containsKey(candidateName)) {
                throw new Exception("Invalid candidate!");
            }

            candidates.get(candidateName).addVote();
            voter.setVoted(true);
            voters.put(name, voter);

            System.out.println("✅ Vote successful!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // ----------- DISPLAY RESULTS -----------
    public static void showResults() {
        System.out.println("\n===== RESULTS =====");
        for (Candidate c : candidates.values()) {
            System.out.println(c.getName() + " : " + c.getVotes());
        }
    }

    // ----------- FILE HANDLING -----------
    public static void saveResults() {
        try (FileWriter fw = new FileWriter("results.txt")) {
            for (Candidate c : candidates.values()) {
                fw.write(c.getName() + " : " + c.getVotes() + "\n");
            }
            System.out.println("✅ Results saved to results.txt");
        } catch (IOException e) {
            System.out.println("❌ File Error: " + e.getMessage());
        }
    }
}