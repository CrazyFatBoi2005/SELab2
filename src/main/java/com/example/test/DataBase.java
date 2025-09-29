package com.example.test;

import com.example.test.Lab2.Items;
import com.example.test.StudentSystem.Student;
import com.example.test.TaskManager.Task;

import java.util.ArrayList;
import java.util.Objects;

public final class DataBase {
    private static final DataBase INSTANCE = new DataBase();

    public static DataBase getInstance() {
        return INSTANCE;
    }

    private final ArrayList<Items> items = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Task> tasks = new ArrayList<>();

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

        tasks.add(new Task(1, "Task 1", "Description", "2026-02-02", true));
        tasks.add(new Task(2, "Task 2", "Description", "2026-02-02", false));
        tasks.add(new Task(3, "Task 3", "Description", "2026-02-02", true));
        tasks.add(new Task(4, "Task 4", "Description", "2026-02-02", false));
        tasks.add(new Task(5, "Task 5", "Description", "2026-02-02", false));
        tasks.add(new Task(6, "Task 6", "Description", "2026-02-02", false));
        tasks.add(new Task(7, "Task 7", "Description", "2026-02-02", false));
        tasks.add(new Task(8, "Task 8", "Description", "2026-02-02", false));
        tasks.add(new Task(9, "Task 9", "Description", "2026-02-02", false));

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

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void addTask(Task task) {
        if (task.getId() == 0L) task.setId(students.size() + 1);
        tasks.add(task);
    }

    public void updateTask(long id, Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.set(i, task);
                return;
            }
        }
    }

    public Task getTask(long id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                return tasks.get(i);
            }
        }
        return null;
    }
}