package home.sabapathy.todo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j

@Data @NoArgsConstructor @AllArgsConstructor
public class TodoRequest {
    private long num;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;
}
