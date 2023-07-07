package ru.venidiktov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.venidiktov.repo.CrudRepository;

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
}