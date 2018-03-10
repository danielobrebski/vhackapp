package pl.pw.vhacks.interfaith_parent_connection.services;

import pl.pw.vhacks.interfaith_parent_connection.dtos.CommentDto;
import pl.pw.vhacks.interfaith_parent_connection.dtos.RateCommentDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentsByPost(Long postId);
    void saveComment(CommentDto commentDto);

    @Transactional
    void voteComment(RateCommentDto rateCommentDto);
}
