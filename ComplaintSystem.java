import java.util.ArrayList;
import java.util.Scanner;

class Complaint {
    int id;
    String department;
    String description;
    boolean resolved;

    Complaint(int id, String department, String description) {
        this.id = id;
        this.department = department;
        this.description = description;
        this.resolved = false;
    }

    public void markResolved() {
        this.resolved = true;
    }

    public String toString() {
        return "ID: " + id + " | Dept: " + department + 
               " | Issue: " + description + 
               " | Status: " + (resolved ? "✅ Resolved" : "❌ Pending");
    }
}

public class ComplaintSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Complaint> complaints = new ArrayList<>();
        int counter = 1;

        while (true) {
            System.out.println("\n=== College Complaint Management ===");
            System.out.println("1. Register Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Resolve Complaint");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Complaint: ");
                    String desc = sc.nextLine();
                    complaints.add(new Complaint(counter++, dept, desc));
                    System.out.println("✅ Complaint registered successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Complaint List ---");
                    for (Complaint c : complaints) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.print("Enter Complaint ID to resolve: ");
                    int id = sc.nextInt();
                    boolean found = false;
                    for (Complaint c : complaints) {
                        if (c.id == id) {
                            c.markResolved();
                            System.out.println("✅ Complaint marked as resolved.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ Complaint not found!");
                    break;

                case 4:
                    System.out.println("👋 Exiting system. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice, try again.");
            }
        }
    }
}
