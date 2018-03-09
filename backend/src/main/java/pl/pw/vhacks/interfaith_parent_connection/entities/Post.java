package pl.pw.vhacks.interfaith_parent_connection.entities;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;
import pl.pw.vhacks.users.User;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class Post implements Serializable {
    private Long id;
    private User user;
    private String text;
    private Long rate;

    @Transient
    private MultipartFile additionalFile;
}
