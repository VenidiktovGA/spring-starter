package ru.venidiktov.repo;

import ru.venidiktov.bpp.InjectBean;
import ru.venidiktov.database.ConnectionPool;

public class UserRepository {
    @InjectBean
    private ConnectionPool connectionPool;
}
