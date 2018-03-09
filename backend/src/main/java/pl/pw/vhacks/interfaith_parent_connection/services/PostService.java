package pl.pw.vhacks.interfaith_parent_connection.services;

import pl.pw.vhacks.interfaith_parent_connection.entities.Post;

import javax.transaction.Transactional;
import java.util.List;

public interface PostService {
    @Transactional(rollbackOn = Exception.class)
    void savePost(Post post);

    List<Post> getPosts(String text);
}
