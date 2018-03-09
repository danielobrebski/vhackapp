package pl.pw.vhacks.users.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.vhacks.users.dtos.UserDto;
import pl.pw.vhacks.users.services.UserService;

@RestController
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    UserDto getUser(@RequestParam String login) {
        return UserDto.mapFromUser(userService.getUserByLogin(login));
    }

}
