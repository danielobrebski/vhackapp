package pl.pw.vhacks.interfaith_parent_connection.services;

import org.springframework.web.multipart.MultipartFile;
import pl.pw.vhacks.interfaith_parent_connection.dtos.PostDto;
import pl.pw.vhacks.interfaith_parent_connection.dtos.RatePostDto;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.users.User;
import pl.pw.vhacks.users.dtos.UserDto;

import javax.transaction.Transactional;
import java.util.List;

public interface PostService {
    @Transactional(rollbackOn = Exception.class)
    void savePost(PostDto postDto, MultipartFile mpf);

    Post getPost(Long postId);

    List<PostDto> getPostsBySearch(String text);

    List<String> getPostHint(String text);

    List<PostDto> getMostCommonPosts();

    List<PostDto> getMostCommonPostsByCountry();

    @Transactional
    void votePost(RatePostDto ratePostDto);

    PostDto getPostById(Long postId);
}
