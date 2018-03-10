package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.pw.vhacks.interfaith_parent_connection.entities.Comment;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.interfaith_parent_connection.repositories.CommentRepository;
import pl.pw.vhacks.interfaith_parent_connection.repositories.PostRepository;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.users.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Order(5)
public class CommentInitializer implements ApplicationRunner {

    @Resource
    private final CommentRepository commentRepository;

    @Resource
    private final PostRepository postRepository;

    @Resource
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addComment(Texts.answer1, Texts.question1);
        addComment(Texts.answer2, Texts.question2);
        addComment(Texts.answer3, Texts.question3);
        addComment(Texts.answer4, Texts.question4);
        addComment(Texts.answer5, Texts.question5);
        addComment(Texts.answer6, Texts.question6);
    }

    private void addComment(String text, String topic) {
        Comment comment = new Comment();
        comment.setUser(getUser());
        comment.setPost(getPost(topic));
        comment.setText(text);
        comment.setRate(new Random().nextLong() % 20);
        commentRepository.save(comment);
    }

    private User getUser() {
        return userRepository.findAll().stream().findAny().get();
    }

    private Post getPost(String topic) {
        return postRepository.getPostByTopic(topic);
    }
}
