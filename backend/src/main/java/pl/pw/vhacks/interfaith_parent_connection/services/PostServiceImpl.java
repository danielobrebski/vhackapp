package pl.pw.vhacks.interfaith_parent_connection.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.pw.vhacks.interfaith_parent_connection.dtos.PostDto;
import pl.pw.vhacks.interfaith_parent_connection.dtos.RatePostDto;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.interfaith_parent_connection.repositories.PostRepository;
import pl.pw.vhacks.interfaith_parent_connection.repositories.SolrPostRepository;
import pl.pw.vhacks.users.services.UserService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private static final int MAX_SIZE = 5;

    @Resource
    private final PostRepository postRepository;

    @Resource
    private final SolrPostRepository solrPostRepository;

    private final UserService userService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void savePost(PostDto postDto, MultipartFile mpf) {
        Post post = new Post();
        post.setTopic(postDto.getTopic());
        post.setText(postDto.getText());
        post.setUser(userService.getUserById(postDto.getUserId()));
        post.setRate(0L);

        postRepository.save(post);
        solrPostRepository.save(post);
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository.getPostById(postId);
    }

    @Override
    public List<PostDto> getPostsBySearch(String text) {
        List<Post> posts = solrPostRepository.queryByTextOrTopic(text, text);
        if (posts != null) {
            return posts
                    .stream()
                    .map(PostDto::mapFromPost)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }


    @Override
    public List<String> getPostHint(String text) {
        List<Post> posts = solrPostRepository.queryByText(text);
        if (posts != null) {
            return posts
                    .stream()
                    .map(Post::getText)
                    .limit(MAX_SIZE)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<PostDto> getMostCommonPosts() {
        return postRepository.getMostPopularComments()
                .stream()
                .map(PostDto::mapFromPost)
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getMostCommonPostsByCountry() {
        return null;
    }

    @Transactional
    @Override
    public void votePost(RatePostDto ratePostDto) {
        Post post = postRepository.getPostById(ratePostDto.getPostId());
        post.setRate(ratePostDto.getPositiveRate() ? post.getRate() + 1 : post.getRate() - 1);
    }
}
