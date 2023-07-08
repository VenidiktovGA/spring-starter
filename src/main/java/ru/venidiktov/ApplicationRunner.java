package ru.venidiktov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.venidiktov.config.ApplicationConfiguration;
import ru.venidiktov.database.ConnectionPool;
import ru.venidiktov.repo.CrudRepository;

public class ApplicationRunner
{
    public static void main( String[] args )
    {
        try(var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            //Установить profile в java коде
//            context.register(ApplicationConfiguration.class);
//            context.getEnvironment().setActiveProfiles("prod");
//            context.refresh();
            var pool = context.getBean("connectionPool", ConnectionPool.class);
            var userRepository = context.getBean("userRepository", CrudRepository.class);
            userRepository.findById(1);
            System.out.println("OK");
        }
    }
}
