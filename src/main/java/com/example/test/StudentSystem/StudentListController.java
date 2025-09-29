package com.example.test.StudentSystem;

import com.example.test.DataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sl")
public class StudentListController {
    private DataBase dataBase = DataBase.getInstance();

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("students", dataBase.getStudents());
        return "students";
    }

    @GetMapping("/add")
    public String studentList(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/add/new")
    public String addStudent(@ModelAttribute("student") Student student) {
        dataBase.addStudent(student);
        return "redirect:/sl/";
    }
}