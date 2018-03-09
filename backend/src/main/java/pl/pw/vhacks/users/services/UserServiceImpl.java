package pl.pw.vhacks.users.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.users.repositories.UserRepository;

import javax.annotation.Resource;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Resource
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
