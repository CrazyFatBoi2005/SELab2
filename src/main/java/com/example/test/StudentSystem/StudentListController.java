package com.example.test.StudentSystem;

import com.example.test.DataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentListController {
    private DataBase dataBase = DataBase.getInstance();

    @GetMapping("/sl/")
    public String indexPage(Model model) {
        model.addAttribute("students", dataBase.getStudents());
        return "students";
    }

    @GetMapping("/sl/add")
    public String studentList(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/sl/add/new")
    public String addStudent(@ModelAttribute("student") Student student) {
        dataBase.addStudent(student);
        return "redirect:/sl/";
    }
}