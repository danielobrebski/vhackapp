package pl.pw.vhacks.users.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Long userId;
}
