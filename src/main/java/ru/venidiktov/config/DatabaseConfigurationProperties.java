package ru.venidiktov.config;

import java.util.List;
import java.util.Map;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Value
@ConfigurationProperties(prefix = "db")
public class DatabaseConfigurationProperties {
    String username;
    String password;
    String driver;
    String url;
    List<String> hosts;
    PoolProperties pool;
    List<PoolProperties> pools;
    Map<String, Object> properties;


    @ConstructorBinding
    public DatabaseConfigurationProperties(String username, String password, String driver,
                                           String url, List<String> hosts, PoolProperties pool,
                                           List<PoolProperties> pools, Map<String, Object> properties) {
        this.username = username;
        this.password = password;
        this.driver = driver;
        this.url = url;
        this.hosts = hosts;
        this.pool = pool;
        this.pools = pools;
        this.properties = properties;
    }

        public record PoolProperties(Integer size, Integer timeout) {}
}
