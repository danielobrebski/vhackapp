package pl.pw.vhacks.interfaith_parent_connection.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.utils.Media;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

    @Column(length = 2000)
    private String text;

    private Long rate;

    @OneToOne
    private Media media;
}
