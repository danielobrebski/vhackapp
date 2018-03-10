package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
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
import pl.pw.vhacks.utils.Media;
import pl.pw.vhacks.utils.repositories.MediaRepository;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Resource
    private final MediaRepository mediaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addComment(Constants.answer1, Constants.question1, null);
        addComment(Constants.answer2, Constants.question2, null);
        addComment(Constants.answer3, Constants.question3, null);
        addComment(Constants.answer4, Constants.question4, null);
        addComment(Constants.answer5, Constants.question5, null);
        addComment(Constants.answer6, Constants.question6, null);
        addComment(null, Constants.question7, Constants.answer7_path1);
        addComment(null, Constants.question7, Constants.answer7_path2);
    }

    private void addComment(String text, String topic, String mediaPath) throws IOException {
        Comment comment = new Comment();
        comment.setUser(getUser());
        comment.setPost(getPost(topic));
        comment.setText(text);
        comment.setRate(new Random().nextLong() % 20);
        comment.setMedia(createMedia(mediaPath));
        commentRepository.save(comment);
    }

    private User getUser() {
        return userRepository.findAll().stream().findAny().get();
    }

    private Post getPost(String topic) {
        return postRepository.getPostByTopic(topic);
    }

    private Media createMedia(String mediaPath) throws IOException {
        Media media = new Media();
        Path path = Paths.get(mediaPath);
        media.setMediaFile(Files.readAllBytes(path));
        mediaRepository.save(media);
        return media;
    }
}
