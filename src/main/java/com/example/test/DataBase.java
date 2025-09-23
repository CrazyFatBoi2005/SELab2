package com.example.test;

import com.example.test.Lab2.Items;
import com.example.test.StudentSystem.Student;

import java.util.ArrayList;
import java.util.Objects;

public final class DataBase {
    private static final DataBase INSTANCE = new DataBase();
    public static DataBase getInstance() { return INSTANCE; }

    private final ArrayList<Items> items = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();

    private DataBase() {
        items.add(new Items(1, "Item 1", "Description 1", 100.00));
        items.add(new Items(2, "Item 2", "Description 2", 200.00));
        items.add(new Items(3, "Item 3", "Description 3", 300.00));
        items.add(new Items(4, "Item 4", "Description 4", 400.00));
        items.add(new Items(5, "Item 5", "Description 5", 500.00));
        items.add(new Items(6, "Item 6", "Description 6", 600.00));
        items.add(new Items(7, "Item 7", "Description 7", 700.00));
        items.add(new Items(8, "Item 8", "Description 8", 800.00));
        items.add(new Items(9, "Item 9", "Description 9", 900.00));

        students.add(new Student(1, "Name 1", "Surname 1", 100, "A"));
        students.add(new Student(2, "Name 2", "Surname 2", 90, "A"));
        students.add(new Student(3, "Name 3", "Surname 3", 80, "B"));
        students.add(new Student(4, "Name 4", "Surname 4", 70, "C"));
        students.add(new Student(5, "Name 5", "Surname 5", 60, "C"));
        students.add(new Student(6, "Name 6", "Surname 6", 50, "D"));
        students.add(new Student(7, "Name 7", "Surname 7", 40, "F"));

    }
    public ArrayList<Items> getItems() {
        return new ArrayList<>(items);
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addItem(Items item) {
        if (item.getId() == 0) item.setId(items.size() + 1);
        items.add(item);
    }

    public void addStudent(Student student) {
        student.calculateMark();
        if (student.getId() == 0L) student.setId(students.size() + 1);
        students.add(student);
    }
}