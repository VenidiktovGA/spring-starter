package ru.venidiktov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.venidiktov.database.ConnectionPool;
import ru.venidiktov.repo.CrudRepository;
import ru.venidiktov.repo.UserRepository;
import web.WebConfiguration;

@Import({WebConfiguration.class})
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(
      basePackages = "ru.venidiktov",
        useDefaultFilters = false,
        includeFilters = {
                @Filter(type= FilterType.ANNOTATION, value = Component.class),
                @Filter(type= FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @Filter(type= FilterType.REGEX, pattern = "ru\\..+Repository")
        }
)
public class ApplicationConfiguration {
        @Bean
        public ConnectionPool pool2(@Value("${db.username}") String username) {
                return new ConnectionPool(username, 20);
        }

        @Profile("prod") //Можно использовать операции ! & | (!prod prod&web prod|web)
        @Bean
        public UserRepository userRepository2(ConnectionPool pool2) {
                return new UserRepository(pool2);
        }
}