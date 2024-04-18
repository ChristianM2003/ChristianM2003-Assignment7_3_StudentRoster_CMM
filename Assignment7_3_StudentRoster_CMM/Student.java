import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student implements Serializable {
    private String firstName;
    private String lastName;
    private double gpa;
    private String currentAddress;
    private String homeAddress;
    private String phoneNumber;

    public Student(String firstName, String lastName, double gpa, String currentAddress, String homeAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.currentAddress = currentAddress;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nGPA: " + gpa + "\nCurrent Address: " + currentAddress +
                "\nHome Address: " + homeAddress + "\nPhone Number: " + phoneNumber + "\n";
    }
}