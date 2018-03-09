package pl.pw.vhacks.interfaith_parent_connection.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.pw.vhacks.interfaith_parent_connection.dtos.CommentDto;
import pl.pw.vhacks.interfaith_parent_connection.dtos.PostDto;
import pl.pw.vhacks.interfaith_parent_connection.services.CommentService;
import pl.pw.vhacks.interfaith_parent_connection.services.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
class PostCommentController {

    private final PostService postService;
    private final CommentService commentService;

    @RequestMapping(value = "/post/insertPost", method = RequestMethod.POST)
    void insertPost(@RequestBody PostDto postDto, @RequestParam("file") MultipartFile mpf) {
        postService.savePost(postDto, mpf);
    }

    @RequestMapping(value = "/post/getPostsBySearch", method = RequestMethod.GET)
    List<PostDto> getPostsBySearch(@RequestParam String searchText) {
        return postService.getPostsBySearch(searchText);
    }

    @RequestMapping(value = "/post/getMostCommonPosts", method = RequestMethod.GET)
    List<PostDto> getMostCommonPosts() {
        return postService.getMostCommonPosts();
    }

    @RequestMapping(value = "/post/hint", method = RequestMethod.GET)
    String getPostHints(@RequestParam String hint) {
        return postService.getPostHint(hint);
    }

    @RequestMapping(value = "/comment/insertComment", method = RequestMethod.POST)
    void insertComment(@RequestBody CommentDto commentDto) {
        commentService.saveComment(commentDto);
    }

    @RequestMapping(value = "/comment/getPostComments", method = RequestMethod.GET)
    List<CommentDto> getPostComments(@RequestParam Long postId) {
        return commentService.getCommentsByPost(postId);
    }

}
