package pl.pw.vhacks.users.controllers;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.vhacks.users.Country;
import pl.pw.vhacks.users.repositories.CountryRepository;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    @Resource
    private final CountryRepository countryRepository;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    List<Country> getCountries() {
        List<Country> countries = Lists.newArrayList(countryRepository.findAll());
        countries.sort(Comparator.comparing(Country::getName));
        return countries;
    }
}
