package home.sabapathy.todo.service.api;

import home.sabapathy.todo.service.entity.Todo;

import java.util.List;

public interface TodoService {

    public Todo save(Todo todo);

    public Todo findByNum(Long number);

    public Todo deleteByNum(Long number);

    public List<Todo> findAll();
}
