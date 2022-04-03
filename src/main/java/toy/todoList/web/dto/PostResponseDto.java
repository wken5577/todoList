package toy.todoList.web.dto;

import lombok.Data;
import toy.todoList.entity.NowStatus;
import toy.todoList.entity.Post;
import toy.todoList.entity.PrimaryScore;

@Data
public class PostResponseDto implements Comparable<PostResponseDto>{

    private Long id;
    private String todoTitle;
    private String person;
    private String memo;
    private Integer primary;
    private NowStatus nowStatus;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.todoTitle = post.getTodoTitle();
        this.person = post.getPerson();
        this.memo = post.getMemo();
        this.nowStatus = post.getNowStatus();
        if(post.getPrimaryScore() == PrimaryScore.FIRST) primary = 1;
        else if(post.getPrimaryScore() == PrimaryScore.SECOND) primary = 2;
        else if(post.getPrimaryScore() == PrimaryScore.THIRD) primary = 3;
    }

    @Override
    public int compareTo(PostResponseDto o) {
        return this.getPrimary() - o.getPrimary();
    }

}
