package pl.pw.vhacks.utils.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.pw.vhacks.users.Country;
import pl.pw.vhacks.users.repositories.CountryRepository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Locale;

@RequiredArgsConstructor
@Component
@Order(2)
public class CountryInitializer implements ApplicationRunner {

    @Resource
    private final CountryRepository countryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Arrays.stream(Locale.getISOCountries())
                .forEach(country -> {
                    Locale locale = new Locale("en", country);
                    createCountry(locale.getDisplayCountry());
                });
    }

    private void createCountry(String name) {
        Country country = new Country();
        country.setName(name);
        countryRepository.save(country);
    }
}
