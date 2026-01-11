package com.example.demo.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/todo")
    public String todoPage() {
        return "todo";  // templates/todo.html を返す
    }
}