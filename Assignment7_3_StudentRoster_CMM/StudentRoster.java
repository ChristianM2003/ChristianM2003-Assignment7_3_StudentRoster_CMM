import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class StudentRoster implements Serializable {
    private ArrayList<Student> roster;

    public StudentRoster() {
        roster = new ArrayList<>();
    }

    public void addStudent(Student student) {
        roster.add(student);
    }

    public void printRoster() {
        if (roster.isEmpty()) {
            System.out.println("Roster is empty.");
        } else {
            for (Student student : roster) {
                System.out.println(student);
            }
        }
    }

    public Student searchStudent(String firstName, String lastName) {
        for (Student student : roster) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }
}