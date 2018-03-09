package pl.pw.vhacks.users.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pw.vhacks.users.Faith;

import java.util.List;

public interface FaithRepository extends CrudRepository<Faith, Long> {
    List<Faith> findAll();
}
