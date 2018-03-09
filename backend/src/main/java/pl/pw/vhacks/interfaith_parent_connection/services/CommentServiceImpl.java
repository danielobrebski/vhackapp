package pl.pw.vhacks.interfaith_parent_connection.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.vhacks.interfaith_parent_connection.dtos.CommentDto;
import pl.pw.vhacks.interfaith_parent_connection.dtos.RateCommentDto;
import pl.pw.vhacks.interfaith_parent_connection.entities.Comment;
import pl.pw.vhacks.interfaith_parent_connection.repositories.CommentRepository;
import pl.pw.vhacks.users.services.UserService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Resource
    private final CommentRepository commentRepository;

    private final PostService postService;
    private final UserService userService;

    @Override
    public List<CommentDto> getCommentsByPost(Long postId) {
        List<Comment> comments = commentRepository.getCommentsByPost(postService.getPost(postId));
        return comments
                .stream()
                .map(CommentDto::mapFromComment)
                .collect(Collectors.toList());
    }

    @Override
    public void saveComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setPost(postService.getPost(commentDto.getPostId()));
        comment.setUser(userService.getUserById(commentDto.getUserId()));
        commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void voteComment(RateCommentDto rateCommentDto) {
        Comment comment = commentRepository.getCommentById(rateCommentDto.getCommentId());
        comment.setRate(rateCommentDto.getPositiveRate() ? comment.getRate() + 1 : comment.getRate() - 1);
    }
}
