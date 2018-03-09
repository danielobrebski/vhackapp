package pl.pw.vhacks.interfaith_parent_connection.entities;

import lombok.Data;
import pl.pw.vhacks.users.User;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class Comment implements Serializable {
    private Long id;
    private Post post;
    private User user;
    private String text;
}
