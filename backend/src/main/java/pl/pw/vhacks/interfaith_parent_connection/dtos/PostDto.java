package pl.pw.vhacks.interfaith_parent_connection.dtos;

import lombok.Data;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;

import java.io.Serializable;

@Data
public class PostDto implements Serializable {

    private String topic;
    private String text;
    private Long userId;
    private Long mediaId;

    public static PostDto mapFromPost(Post post) {
        PostDto postDto = new PostDto();
        postDto.setUserId(post.getUser().getId());
        postDto.setText(post.getText());
        postDto.setTopic(post.getTopic());
        postDto.setMediaId(post.getMediaFile() != null ? post.getMediaFile().getId() : null);
        return postDto;
    }
}
