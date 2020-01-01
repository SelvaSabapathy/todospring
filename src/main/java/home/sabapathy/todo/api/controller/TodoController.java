package home.sabapathy.todo.api.controller;

import home.sabapathy.todo.api.mapper.TodoMapper;
import home.sabapathy.todo.api.model.TodoRequest;
import home.sabapathy.todo.api.model.TodoResponse;
import home.sabapathy.todo.service.api.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @Autowired
    TodoMapper todoMapper;

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<TodoResponse> save(@PathVariable String username, @RequestBody TodoRequest todoRequest) {
        TodoResponse todoResponse = todoMapper.toTodoResponse(todoService.save(todoMapper.toTodo(todoRequest)));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{num}").buildAndExpand(todoResponse.getNum()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users/{username}/todos/{num}")
    public ResponseEntity<TodoResponse> update(@PathVariable String username, @PathVariable Long num, @RequestBody TodoRequest todoRequest) {
        TodoResponse todoResponse = todoMapper.toTodoResponse(todoService.save(todoMapper.toTodo(todoRequest)));
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }

    @GetMapping("/users/{username}/todos/{num}")
    public TodoResponse get(@PathVariable String username, @PathVariable Long num) {
        return todoMapper.toTodoResponse(todoService.findByNum(num));
    }

    @DeleteMapping("/users/{username}/todos/{num}")
    public ResponseEntity<Void> delete(@PathVariable Long num) {
        TodoResponse todoResponse = todoMapper.toTodoResponse(todoService.deleteByNum(num));
        if (todoResponse != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/todos")
    public List<TodoResponse> getAll(@PathVariable String username) {
        return todoMapper.todoResponses(todoService.findAll());
    }

}
