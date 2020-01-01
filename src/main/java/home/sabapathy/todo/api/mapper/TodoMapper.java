package home.sabapathy.todo.api.mapper;

import home.sabapathy.todo.api.model.TodoRequest;
import home.sabapathy.todo.api.model.TodoResponse;
import home.sabapathy.todo.service.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoResponse toTodoResponse(Todo todo);

    Todo toTodo(TodoRequest todoRequest);

    List<TodoResponse> todoResponses(List<Todo> todos);
}
