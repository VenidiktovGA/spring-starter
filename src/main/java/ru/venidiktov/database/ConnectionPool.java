package ru.venidiktov.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPool {
    private final String username;
    private final Integer poolSize;

    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.pool.size}") Integer poolSize) {
        System.out.println("Call constructor class");
        this.username = username;
        this.poolSize = poolSize;
    }

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
