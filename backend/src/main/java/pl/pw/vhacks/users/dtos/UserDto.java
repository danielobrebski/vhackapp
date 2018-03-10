package pl.pw.vhacks.users.dtos;

import lombok.Data;
import pl.pw.vhacks.users.User;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Long userId;
    private String login;
    private String name;
    private Long mediaId;

    public static UserDto mapFromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setMediaId(user.getMedia() != null ? user.getMedia().getId() : null);
        userDto.setName(user.getName());
        return userDto;
    }
}
