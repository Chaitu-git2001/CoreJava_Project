package com.collection.demo.Entity;

public class Student implements Comparable<Student>{
    private int rollNumber;
    private String name;
    private String department;
    private double cgpa;

    public Student(int rollNumber, String name, String department, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
    }

    // Getters and Setters
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    // toString method for easy display
    @Override
    public String toString() {
        return "RollNumber: " + rollNumber +
                ", Name: " + name +
                ", Department: " + department +
                ", CGPA: " + cgpa;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.cgpa, this.cgpa);
    }
}
