package ru.venidiktov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.venidiktov.database.ConnectionPool;

public class ApplicationRunner
{
    public static void main( String[] args )
    {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var pool = context.getBean("pool1", ConnectionPool.class);
        System.out.println("OK");
    }
}
