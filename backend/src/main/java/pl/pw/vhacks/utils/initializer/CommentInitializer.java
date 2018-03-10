package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.pw.vhacks.interfaith_parent_connection.repositories.CommentRepository;
import pl.pw.vhacks.users.services.UserService;

import javax.annotation.Resource;

@RequiredArgsConstructor
@Component
public class CommentInitializer implements ApplicationRunner {

    @Resource
    private final CommentRepository commentRepository;

    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
