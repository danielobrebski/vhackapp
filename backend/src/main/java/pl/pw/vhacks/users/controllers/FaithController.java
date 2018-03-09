package pl.pw.vhacks.users.controllers;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.vhacks.users.Faith;
import pl.pw.vhacks.users.repositories.FaithRepository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FaithController {

    @Resource
    private final FaithRepository faithRepository;

    @RequestMapping(value = "/faiths", method = RequestMethod.GET)
    List<Faith> getFaiths() throws SQLException {
        return Lists.newArrayList(faithRepository.findAll());
    }
}
