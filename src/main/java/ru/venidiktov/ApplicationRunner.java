package ru.venidiktov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.venidiktov.database.ConnectionPool;
import ru.venidiktov.repo.UserRepository;

public class ApplicationRunner
{
    public static void main( String[] args )
    {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var pool = context.getBean("pool1", ConnectionPool.class);
        var userRepository = context.getBean("userRepository", UserRepository.class);
        System.out.println("OK");
    }
}
