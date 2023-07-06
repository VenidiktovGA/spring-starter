package ru.venidiktov.repo;

import jakarta.annotation.PostConstruct;
import java.util.Optional;
import ru.venidiktov.bpp.Audit;
import ru.venidiktov.bpp.InjectBean;
import ru.venidiktov.bpp.Transaction;
import ru.venidiktov.database.ConnectionPool;
import ru.venidiktov.entity.User;

@Audit
@Transaction
public class UserRepository implements CrudRepository<Integer, User> {
    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init() {
        System.out.println("Call init method from UserRepository class");
    }

    @Override
    public Optional<User> findById(Integer id) {
        System.out.println("Call method findById() from UserRepository class");
        return Optional.of(new User(id));
    }

    @Override
    public void delete(User entity) {
        System.out.println("Call method delete() from UserRepository class");

    }
}
