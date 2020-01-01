package home.sabapathy.todo.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Slf4j

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Todo {
    @Id
    private long id;
    private long num;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;
}
