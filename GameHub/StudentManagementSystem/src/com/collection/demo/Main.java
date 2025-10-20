package com.collection.demo;

import com.collection.demo.Entity.Student;
import com.collection.demo.Service.StudentManagementSystem;

import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Take student details from user
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i + 1) + ":");
            System.out.print("Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();
            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine(); // consume newline

            students.add(new Student(roll, name, dept, cgpa));
        }

        // Call all functionalities
        StudentManagementSystem.registrationList(new ArrayList(students));
        StudentManagementSystem.meritList(new ArrayList(students));
        StudentManagementSystem.alphabeticalList(new ArrayList(students));
        StudentManagementSystem.departmentGrouping(new ArrayList(students));
        StudentManagementSystem.uniqueNames(new ArrayList(students));
        StudentManagementSystem.rollNumberSorting(new ArrayList(students));
        StudentManagementSystem.performanceFilter(new ArrayList(students));
        StudentManagementSystem.recentRegistrations(new ArrayList(students));
        StudentManagementSystem.scholarshipQueue(new ArrayList(students));
        StudentManagementSystem.hostelApplications(new ArrayList(students),sc);

        sc.close();
    }
}
