package ru.venidiktov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.venidiktov.database.ConnectionPool;
import ru.venidiktov.repo.CrudRepository;
import ru.venidiktov.repo.UserRepository;

public class ApplicationRunner
{
    public static void main( String[] args )
    {
        try(var context = new ClassPathXmlApplicationContext("application.xml")) {
            var pool = context.getBean("connectionPool", ConnectionPool.class);
            var userRepository = context.getBean("userRepository", CrudRepository.class);
            userRepository.findById(1);
            System.out.println("OK");
        }
    }
}
