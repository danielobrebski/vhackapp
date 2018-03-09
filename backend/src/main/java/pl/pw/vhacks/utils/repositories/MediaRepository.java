package pl.pw.vhacks.utils.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pw.vhacks.utils.Media;

@Repository
public interface MediaRepository extends CrudRepository<Media, Long> {
    Media findMediaById(Long id);
}
