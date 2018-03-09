package pl.pw.vhacks.interfaith_parent_connection.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.utils.Media;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @OneToOne
    private Post post;

    @ManyToOne
    private User user;

    private String text;

    private Long rate;

    @OneToOne
    private Media media;
}
