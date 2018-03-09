package pl.pw.vhacks.users.services;

import pl.pw.vhacks.users.User;

public interface UserService {
    User getUserById(Long userId);
    User getUserByLogin(String login);
}
