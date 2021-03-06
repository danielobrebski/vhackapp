package pl.pw.vhacks.interfaith_parent_connection.dtos;

import lombok.Data;
import pl.pw.vhacks.interfaith_parent_connection.entities.Comment;

import java.io.Serializable;

@Data
public class CommentDto implements Serializable {

    private Long commentId;
    private String text;
    private Long userId;
    private Long postId;
    private Long rate;
    private Long mediaId;

    public static CommentDto mapFromComment(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setCommentId(comment.getId());
        commentDto.setUserId(comment.getUser().getId());
        commentDto.setText(comment.getText());
        commentDto.setPostId(comment.getPost().getId());
        commentDto.setRate(comment.getRate());
        commentDto.setMediaId(comment.getMedia() != null ? comment.getMedia().getId() : null);
        return commentDto;
    }
}
