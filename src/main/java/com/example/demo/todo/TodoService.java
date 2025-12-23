package com.example.demo.todo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repo;
    public TodoService(TodoRepository repo) { this.repo = repo; }

    public List<Todo> findAll() { return repo.findAll(); }
    public Todo findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Todo create(Todo t) { t.setId(null); return repo.save(t); }
    public Todo update(Long id, Todo t) {
        Todo cur = findById(id);
        cur.setTitle(t.getTitle());
        cur.setCompleted(t.isCompleted());
        cur.setDueAt(t.getDueAt());
        return repo.save(cur);
    }
    public void delete(Long id) { repo.deleteById(id); }
}

