package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
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
        addPost(Texts.question1, null);
        addPost(Texts.question2, null);
        addPost(Texts.question3, null);
        addPost(Texts.question4, null);
        addPost(Texts.question5, null);
        addPost(Texts.question6, null);
    }

    private void addPost(String topic, String text) {
        Post post = new Post();
        post.setUser(getUser());
        post.setTopic(topic);
        post.setText(text);
        post.setRate(new Random().nextLong() % 20);
        postRepository.save(post);
        solrPostRepository.save(post);
    }

    private User getUser() {
        return userRepository.findAll().stream().findAny().get();
    }


}