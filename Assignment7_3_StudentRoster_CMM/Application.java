import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRoster roster = new StudentRoster();

        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Enter student information");
            System.out.println("2. Print student roster");
            System.out.println("3. Search for a student");
            System.out.println("4. Save student roster to disk");
            System.out.println("5. Read student roster from disk");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(roster, scanner);
                    break;
                case 2:
                    roster.printRoster();
                    break;
                case 3:
                    searchStudent(roster, scanner);
                    break;
                case 4:
                    saveRoster(roster);
                    break;
                case 5:
                    roster = readRoster();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private static void addStudent(StudentRoster roster, Scanner scanner) {
        System.out.print("Enter student's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student's last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student's GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter student's current address: ");
        String currentAddress = scanner.nextLine();
        System.out.print("Enter student's home address: ");
        String homeAddress = scanner.nextLine();
        System.out.print("Enter student's phone number: ");
        String phoneNumber = scanner.nextLine();

        Student student = new Student(firstName, lastName, gpa, currentAddress, homeAddress, phoneNumber);
        roster.addStudent(student);
    }

    private static void searchStudent(StudentRoster roster, Scanner scanner) {
        System.out.print("Enter student's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student's last name: ");
        String lastName = scanner.nextLine();

        Student student = roster.searchStudent(firstName, lastName);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void saveRoster(StudentRoster roster) {
        try {
            FileOutputStream fos = new FileOutputStream("roster.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(roster);
            oos.close();
            fos.close();
            System.out.println("Roster saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving roster: " + e.getMessage());
        }
    }

    private static StudentRoster readRoster() {
        StudentRoster roster = null;
        try {
            FileInputStream fis = new FileInputStream("roster.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            roster = (StudentRoster) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Roster loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading roster: " + e.getMessage());
        }
        return roster != null ? roster : new StudentRoster();
    }
}