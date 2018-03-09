package pl.pw.vhacks.users.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pw.vhacks.users.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAll();
}
