package io.github.springboot.springarchitecture.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public TodoEntity save(TodoEntity newTodo) {
        return repository.save(newTodo);
    }
}
