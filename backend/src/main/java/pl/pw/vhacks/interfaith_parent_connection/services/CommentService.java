package pl.pw.vhacks.interfaith_parent_connection.services;

import pl.pw.vhacks.interfaith_parent_connection.dtos.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentsByPost(Long postId);
    void saveComment(CommentDto commentDto);
}
