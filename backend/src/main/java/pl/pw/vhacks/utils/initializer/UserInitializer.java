package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.pw.vhacks.users.Country;
import pl.pw.vhacks.users.Faith;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.users.repositories.CountryRepository;
import pl.pw.vhacks.users.repositories.FaithRepository;
import pl.pw.vhacks.users.repositories.UserRepository;

import javax.annotation.Resource;

@RequiredArgsConstructor
@Component
@Order(3)
public class UserInitializer implements ApplicationRunner {

    @Resource
    private final UserRepository userRepository;

    @Resource
    private final CountryRepository countryRepository;

    @Resource
    private final FaithRepository faithRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createUser("Maja");
        createUser("Weronika");
        createUser("Natalia");
        createUser("Michal");
        createUser("Daniel");
    }

    private void createUser(String name) {
        User user = new User();
        user.setName(name);
        user.setCountry(getAnyCountry());
        user.setFaith(getNextFaith());
        user.setLogin(name + "_login");
        user.setPassword(name + "_password");
        userRepository.save(user);
    }

    private Country getAnyCountry() {
        return countryRepository.findAll().stream().findAny().get();
    }

    private Faith getNextFaith() {
        return faithRepository.findAll().stream().findAny().get();
    }
}
