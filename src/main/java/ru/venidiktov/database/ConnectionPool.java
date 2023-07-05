package ru.venidiktov.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;

public class ConnectionPool implements InitializingBean {
    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private Map<String, Object> properties;

    public ConnectionPool(String username, Integer poolSize, List<Object> args, Map<String, Object> properties) {
        System.out.println("Call constructor class");
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        System.out.println("Call set DI");
        this.properties = properties;
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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.print("Initialization callback. ");
        System.out.println("Call init-method from xml InitializingBean");
    }
}
