package pl.pw.vhacks.interfaith_parent_connection.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.vhacks.interfaith_parent_connection.entities.Comment;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.interfaith_parent_connection.services.CommentService;
import pl.pw.vhacks.interfaith_parent_connection.services.PostService;

@RestController
@RequiredArgsConstructor
class PostCommentController {

    private final PostService postService;
    private final CommentService commentService;


    @RequestMapping(value = "post/insertPost", method = RequestMethod.POST)
    void insertPost(@RequestBody Post post) {
        postService.savePost(post);
    }

    @RequestMapping(value = "comment/insertComment", method = RequestMethod.POST)
    void insertComment(@RequestBody Comment comment) {
        commentService.
    }



}
