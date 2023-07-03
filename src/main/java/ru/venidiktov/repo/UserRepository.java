package ru.venidiktov.repo;

import ru.venidiktov.database.ConnectionPool;

public class UserRepository {
    private final ConnectionPool connectionPool;

    private UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static UserRepository of(ConnectionPool connectionPool) {
        return new UserRepository(connectionPool);
    }
}
