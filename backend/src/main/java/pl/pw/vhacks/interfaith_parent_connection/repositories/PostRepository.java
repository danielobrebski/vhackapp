package pl.pw.vhacks.interfaith_parent_connection.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pw.vhacks.interfaith_parent_connection.dtos.PostDto;
import pl.pw.vhacks.interfaith_parent_connection.entities.Comment;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.users.User;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Post getPostById(Long postId);

    Post getPostByTopic(String topic);

    @Query("select p from Post p order by rate desc")
    List<Post> getMostPopularComments();

    @Query("select p from Post p")
    List<Post> getMostPopularCommentByCountry();

    List<Post> getPostsById(Long postId);
}
