package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private DataBase dataBase = DataBase.getInstance();

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("items", dataBase.getItems());
        return "index";
    }

    @GetMapping("/items")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Items());
        return "item-form";
    }

    @PostMapping("/items/new")
    public String createItem(@ModelAttribute("item") Items item) {
        dataBase.addItem(item);
        return "redirect:/";
    }
}