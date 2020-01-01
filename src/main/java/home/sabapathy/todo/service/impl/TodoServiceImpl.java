package home.sabapathy.todo.service.impl;

import home.sabapathy.todo.service.api.TodoService;
import home.sabapathy.todo.service.entity.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j

@Service
public class TodoServiceImpl implements TodoService {

    private static long idCounter = 0L;

    private static long numberCounter = 0L;
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(++idCounter, ++numberCounter, "selva", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, ++numberCounter, "selva", "Learn Spring Boot", new Date(), true));
        todos.add(new Todo(++idCounter, ++numberCounter, "selva", "Learn Docker", new Date(), false));
    }

    @Override
    public Todo save(Todo todo) {
        if (deleteByNum(todo.getNum()) == null) {
            todo.setId(++idCounter);
            todo.setNum(++numberCounter);
        }
        todos.add(todo);
        return todo;
    }

    @Override
    public Todo findByNum(Long number) {
        for (Todo todo : TodoServiceImpl.todos) {
            if (todo.getNum() == number) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public Todo deleteByNum(Long number) {
        Todo todo = findByNum(number);
        if (todo != null && todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }
}
