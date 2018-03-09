package pl.pw.vhacks.interfaith_parent_connection.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.users.User;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> getPostByUser(User user);
}
