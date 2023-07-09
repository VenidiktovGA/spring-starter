package ru.venidiktov.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.venidiktov.config.condition.JpaCondition;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {
    @PostConstruct
    void init() {
        System.out.println("Jpa конфигурация применена");
    }
}
