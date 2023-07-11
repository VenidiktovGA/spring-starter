package ru.venidiktov.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.venidiktov.config.condition.JpaCondition;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseConfigurationProperties databaseConfigurationProperties() {
//        return new DatabaseConfigurationProperties();
//    }
    @PostConstruct
    void init() {
        System.out.println("Jpa конфигурация применена");
    }
}
