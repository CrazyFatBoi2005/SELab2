package com.example.test.Lab2;

import com.example.test.DataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private DataBase dataBase = DataBase.getInstance();

    @GetMapping("/lab2/")
    public String indexPage(Model model) {
        model.addAttribute("items", dataBase.getItems());
        return "index";
    }

    @GetMapping("/lab2/items")
    public String newItemForm(Model model) {
        model.addAttribute("item", new Items());
        return "item-form";
    }

    @PostMapping("/lab2/items/new")
    public String createItem(@ModelAttribute("item") Items item) {
        dataBase.addItem(item);
        return "redirect:/";
    }
}