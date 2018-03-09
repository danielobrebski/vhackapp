package pl.pw.vhacks.interfaith_parent_connection.dtos;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
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

    @Indexed(name = "userId", type = "string")
    private Long userId;

    @Indexed(name = "mediaId", type = "string")
    private Long mediaId;

    public static PostDto mapFromPost(Post post) {
        PostDto postDto = new PostDto();
        postDto.setUserId(post.getUser().getId());
        postDto.setText(post.getText());
        postDto.setTopic(post.getTopic());
        return postDto;
    }
}
