package io.github.springboot.springarchitecture;

import io.github.springboot.springarchitecture.todos.TodoEntity;
import io.github.springboot.springarchitecture.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON) // (padrão - singleton)
// @Scope("request")  - web application - is founded in "WebApplicationContext.SCOPE_"
// @Scope("session") - web application
// @Scope("application") - web application
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void ultilizar() {
        var todo = new TodoEntity();
        validator.validate(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
