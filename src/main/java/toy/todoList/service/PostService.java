package toy.todoList.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.todoList.entity.NowStatus;
import toy.todoList.entity.Post;
import toy.todoList.entity.PrimaryScore;
import toy.todoList.web.controller.PostRepository;
import toy.todoList.web.dto.PostResponseDto;

import java.util.*;


@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;


    public void createPost(String todoTitle, String person, String memo, Integer primary) {
        PrimaryScore primaryScore;
        if(primary == 1) primaryScore = PrimaryScore.FIRST;
        else if(primary == 2) primaryScore = PrimaryScore.SECOND;
        else primaryScore = PrimaryScore.THIRD;

        Post post = new Post(todoTitle, person, memo, primaryScore);
        postRepository.save(post);
    }


    public Map<NowStatus, List<PostResponseDto>> getAllPost() {
        List<Post> posts = postRepository.findAll();

        Map<NowStatus, List<PostResponseDto>> result = new HashMap<>();
        result.put(NowStatus.TODO, new ArrayList<>());
        result.put(NowStatus.NOW_DOING, new ArrayList<>());
        result.put(NowStatus.FINISH, new ArrayList<>());

        for (Post post : posts) {
            if(post.getNowStatus() == NowStatus.TODO) result.get(NowStatus.TODO).add(new PostResponseDto(post));
            else if(post.getNowStatus() == NowStatus.NOW_DOING) result.get(NowStatus.NOW_DOING).add(new PostResponseDto(post));
            else result.get(NowStatus.FINISH).add(new PostResponseDto(post));
        }

        for (List<PostResponseDto> value : result.values()) {
            Collections.sort(value);
        }

        return result;
    }

    public void changeStatus(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);
        post.changeStatus();
    }
}
