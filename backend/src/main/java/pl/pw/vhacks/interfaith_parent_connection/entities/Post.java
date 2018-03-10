package pl.pw.vhacks.interfaith_parent_connection.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.web.multipart.MultipartFile;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.utils.Media;

import javax.persistence.Column;
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
@SolrDocument(solrCoreName = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @ManyToOne
    private User user;

    @Indexed(name = "topic", type = "string")
    @Column(length = 2000)
    private String topic;

    @Indexed(name = "text", type = "string")
    @Column(length = 2000)
    private String text;

    private Long rate;

    @OneToMany
    private List<Comment> comments;

    @OneToOne
    private Media mediaFile;
}
