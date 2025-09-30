package com.example.test.TaskManager; // оставил ваш пакет, можно переименовать позже

import com.example.test.DataBase;
import com.example.test.TaskManager.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tm")
public class TaskManagerController {
    private final DataBase dataBase = DataBase.getInstance();

    @GetMapping("/")
    public String taskList(Model model) {
        model.addAttribute("tasks", dataBase.getTasks());
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    @PostMapping("/add/new")
    public String createTask(@ModelAttribute("newTask") Task task) {
        dataBase.addTask(task);
        return "redirect:/tm/";
    }

    @GetMapping("/{id}/")
    public String editTask(@PathVariable long id, Model model) {
        Task task = dataBase.getTask(id);
        model.addAttribute("task", task);
        return "task-edit";
    }

    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable long id, @ModelAttribute("task") Task task) {
        dataBase.updateTask(id, task);
        return "redirect:/tm/";
    }
}
