package pl.pw.vhacks.interfaith_parent_connection.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.interfaith_parent_connection.repositories.PostRepository;
import pl.pw.vhacks.interfaith_parent_connection.repositories.SolrPostRepository;
import pl.pw.vhacks.users.User;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Resource
    private final PostRepository postRepository;

    @Resource
    private final SolrPostRepository solrPostRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void savePost(Post post) {
        postRepository.save(post);
        solrPostRepository.save(post);
    }

    @Override
    public List<Post> getPosts(String text) {
        return solrPostRepository.findByText(text);
    }

    public List<Post> getUserPosts(User user) {
        return postRepository.getPostByUser()
    }
}
