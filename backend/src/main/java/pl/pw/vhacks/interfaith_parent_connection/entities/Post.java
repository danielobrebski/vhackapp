package pl.pw.vhacks.interfaith_parent_connection.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.utils.Media;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @ManyToOne
    private User user;
    private String topic;
    private String text;
    private Long rate;

    @OneToMany
    private List<Comment> comments;

    @OneToOne
    private Media mediaFile;
}
