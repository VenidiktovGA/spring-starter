package ru.venidiktov.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConnectionPool {
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.info("Initialization callback. ");
        log.info("Call init-method from annotation");
    }

    @PreDestroy
    private void destroy(){
        log.info("Destroy callback. ");
        log.info("Call destroy-method from annotation");
    }
}
