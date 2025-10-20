package com.collection.demo.Service;

import com.collection.demo.Entity.Student;

import java.util.*;

public class StudentManagementSystem {
    // 1. Registration List - ArrayList
    public static void registrationList(List<Student> students) {
        System.out.println("\nRegistration List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 2. Merit List - Comparable<Student>
    public static void meritList(List<Student> students) {
        Collections.sort(students, Collections.reverseOrder());
        // uses compareTo (descending CGPA)
        System.out.println("\nMerit List (by CGPA):");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 3. Alphabetical List - Comparator<Student>
    public static void alphabeticalList(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println("\nAlphabetical List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }


    // 4. Department Grouping - HashMap<String, List<Student>>
    public static void departmentGrouping(List<Student> students) {
        Map<String, List<Student>> deptMap = new HashMap();
        for (Student s : students) {
            String dept = s.getDepartment();
            if (!deptMap.containsKey(dept)) {
                deptMap.put(dept, new ArrayList());
            }
            deptMap.get(dept).add(s);
        }
        System.out.println("\nDepartment Grouping:");
        for (Map.Entry<String, List<Student>> entry : deptMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i).getName());
                if (i < entry.getValue().size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    // 5. Unique Names - HashSet<String>
    public static void uniqueNames(List<Student> students) {
        Set<String> uniqueNames = new HashSet();
        for (Student s : students) {
            uniqueNames.add(s.getName());
        }
        System.out.println("\nUnique Names:");
        for (String name : uniqueNames) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    // 6. Roll Number Sorting - TreeSet<Student>
    public static void rollNumberSorting(List<Student> students) {
        TreeSet<Student> sortedSet = new TreeSet(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getRollNumber() - s2.getRollNumber();
            }
        });
        sortedSet.addAll(students);
        System.out.println("\nRoll Number Sorting:");
        for (Student s : sortedSet) {
            System.out.println(s);
        }
    }

    // 7. Performance Filter - Iterator
    public static void performanceFilter(List<Student> students) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getCgpa() < 5.0) {
                it.remove();
            }
        }
        System.out.println("\nPerformance Filter (CGPA >= 5.0):");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 8. Recent Registrations - Stack<Student>
    public static void recentRegistrations(List<Student> students) {
        Stack<Student> stack = new Stack();
        stack.addAll(students);
        System.out.println("\nRecent Registrations (LIFO):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // 9. Scholarship Queue - Queue<Student>
    public static void scholarshipQueue(List<Student> students) {
        Queue<Student> queue = new LinkedList();
        queue.addAll(students);
        System.out.println("\nScholarship Queue (FIFO):");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    // 10. Hostel Applications - LinkedList<Integer>
    // 10. Hostel Applications - LinkedList<Integer>
    public static void hostelApplications(List<Student> students, Scanner sc) {
        LinkedList<Integer> hostelList = new LinkedList();

        System.out.println("\n--- Hostel Applications ---");

        for (Student s : students) {
            System.out.print("Is student " + s.getName() + " (Roll " + s.getRollNumber() + ") a priority applicant? (yes/no): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("yes")) {
                hostelList.addFirst(s.getRollNumber()); // add priority at front
            } else {
                hostelList.addLast(s.getRollNumber());  // add regular at end
            }
        }

        // Display initial queue
        System.out.println("\nHostel Applications: " + hostelList);

        // Allocate from front
        if (!hostelList.isEmpty()) {
            System.out.println("Allocated Front: " + hostelList.removeFirst());
        }

        // Allocate from end
        if (!hostelList.isEmpty()) {
            System.out.println("Allocated End: " + hostelList.removeLast());
        }

        // Remaining applicants
        System.out.println("Remaining Applicants: " + hostelList);
    }

}
