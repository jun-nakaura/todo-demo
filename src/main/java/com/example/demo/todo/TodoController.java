package com.example.demo.todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService service;
    public TodoController(TodoService service) { this.service = service; }

    @GetMapping
    public List<Todo> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public Todo get(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo t) { return service.create(t); }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo t) { return service.update(id, t); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }

    
}
