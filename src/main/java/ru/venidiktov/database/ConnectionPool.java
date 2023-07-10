package ru.venidiktov.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConnectionPool {
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.print("Initialization callback. ");
        System.out.println("Call init-method from annotation");
    }

    @PreDestroy
    private void destroy(){
        System.out.print("Destroy callback. ");
        System.out.println("Call destroy-method from annotation");
    }
}
