package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.interfaith_parent_connection.entities.SolrPost;
import pl.pw.vhacks.interfaith_parent_connection.repositories.PostRepository;
import pl.pw.vhacks.interfaith_parent_connection.repositories.SolrPostRepository;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.users.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Order(4)
public class PostInitializer implements ApplicationRunner {

    @Resource
    private final PostRepository postRepository;

    @Resource
    private final SolrPostRepository solrPostRepository;

    @Resource
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addPost(Constants.question1, null);
        addPost(Constants.question2, null);
        addPost(Constants.question3, null);
        addPost(Constants.question4, null);
        addPost(Constants.question5, null);
        addPost(Constants.question6, null);
        addPost(Constants.question7, null);
    }

    private void addPost(String topic, String text) {
        Post post = new Post();
        post.setUser(getUser());
        post.setTopic(topic);
        post.setText(text);
        post.setRate(new Random().nextLong() % 20);
        postRepository.save(post);

        SolrPost solrPost = new SolrPost();
        solrPost.setId(post.getId());
        solrPost.setTopic(post.getTopic());
        solrPostRepository.save(solrPost);
    }

    private User getUser() {
        return userRepository.findAll().stream().findAny().get();
    }


}
