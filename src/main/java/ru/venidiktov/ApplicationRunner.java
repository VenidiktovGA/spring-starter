package ru.venidiktov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.venidiktov.config.ApplicationConfiguration;
import ru.venidiktov.service.UserService;

public class ApplicationRunner
{
    public static void main( String[] args )
    {
        try(var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var userService = context.getBean("userService", UserService.class);
            userService.findById(1);
        }
    }
}
