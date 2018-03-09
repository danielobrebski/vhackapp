package pl.pw.vhacks.interfaith_parent_connection.dtos;

import lombok.Data;
import pl.pw.vhacks.interfaith_parent_connection.entities.Comment;

import java.io.Serializable;

@Data
public class CommentDto implements Serializable {
    private String text;
    private Long userId;
    private Long postId;

    public static CommentDto mapFromComment(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setUserId(comment.getUser().getId());
        commentDto.setText(comment.getText());
        commentDto.setPostId(comment.getPost().getId());
        return commentDto;
    }
}
