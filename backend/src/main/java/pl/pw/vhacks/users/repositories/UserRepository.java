package pl.pw.vhacks.users.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pw.vhacks.users.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long userId);
}
