package pl.pw.vhacks.users.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pw.vhacks.users.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findUserById(Long userId);
    User findUserByLogin(String login);
}
