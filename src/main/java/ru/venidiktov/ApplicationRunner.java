package ru.venidiktov;

import ru.venidiktov.database.ConnectionPool;
import ru.venidiktov.ioc.Container;
import ru.venidiktov.repo.UserRepository;
import ru.venidiktov.service.UserService;

public class ApplicationRunner
{
    public static void main( String[] args )
    {
        var container = new Container();
        var userService = container.get(UserService.class);
    }
}
