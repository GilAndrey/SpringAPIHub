package io.github.springboot.springarchitecture.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity newTodo) {
        return repository.save(newTodo);
    }

    public void updateStatus (TodoEntity todo) {
        repository.save(todo);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
