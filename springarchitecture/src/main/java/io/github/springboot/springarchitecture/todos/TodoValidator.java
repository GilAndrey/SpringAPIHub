package io.github.springboot.springarchitecture.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validate(TodoEntity todo) {
        if (existeTodoComDescricao(todo.getDescription())) {
            throw new IllegalArgumentException("There is already something with this description!");
        }
    }

    private boolean existeTodoComDescricao(String description){
        return repository.existsByDescription(description);
    }
}
