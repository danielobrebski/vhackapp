package pl.pw.vhacks.interfaith_parent_connection.dtos;

import lombok.Data;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;

import java.io.Serializable;

@Data
@SolrDocument(solrCoreName = "post")
public class PostDto implements Serializable {

    @Indexed(name = "topic", type = "string")
    private String topic;

    @Indexed(name = "text", type = "string")
    private String text;

    private Long userId;

    public static PostDto mapFromPost(Post post) {
        PostDto postDto = new PostDto();
        postDto.setUserId(post.getUser().getId());
        postDto.setText(post.getText());
        postDto.setTopic(post.getTopic());
        return postDto;
    }
}
