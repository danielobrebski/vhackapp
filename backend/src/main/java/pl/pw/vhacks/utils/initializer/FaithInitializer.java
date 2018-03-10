package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.pw.vhacks.users.Faith;
import pl.pw.vhacks.users.repositories.FaithRepository;

import javax.annotation.Resource;

@RequiredArgsConstructor
@Component
@Order(1)
public class FaithInitializer implements ApplicationRunner {

    @Resource
    private final FaithRepository faithRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createFaith("Judaism");
        createFaith("Christianity");
        createFaith("Hinduism");
        createFaith("Muslims");
    }


    private void createFaith(String name) {
        Faith faith = new Faith();
        faith.setName(name);
        faithRepository.save(faith);
    }


}
