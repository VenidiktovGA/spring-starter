package ru.venidiktov.repo;

import jakarta.annotation.PostConstruct;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.venidiktov.bpp.Audit;
import ru.venidiktov.bpp.InjectBean;
import ru.venidiktov.bpp.Transaction;
import ru.venidiktov.database.ConnectionPool;
import ru.venidiktov.entity.User;

@Slf4j
@Audit
@Transaction
@Repository
@RequiredArgsConstructor
public class UserRepository implements CrudRepository<Integer, User> {
    private final ConnectionPool connectionPool;

    @PostConstruct
    private void init() {
        log.info("Call init method from UserRepository class");
    }

    @Override
    public Optional<User> findById(Integer id) {
        log.info("Call method findById() from UserRepository class");
        return Optional.of(new User(id));
    }

    @Override
    public void delete(User entity) {
        log.info("Call method delete() from UserRepository class");

    }
}
