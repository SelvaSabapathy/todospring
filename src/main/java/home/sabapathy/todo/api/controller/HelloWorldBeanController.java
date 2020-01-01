package home.sabapathy.todo.api.controller;

import home.sabapathy.todo.api.model.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldBeanController {

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
//        return new HelloWorldBean("Selva Sabapathy");
        throw new RuntimeException("Server down!");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Welcome, %s", name));
    }
}
