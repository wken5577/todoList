package toy.todoList.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String todoTitle;

    private String person;

    private String memo;

    @Enumerated(EnumType.STRING)
    private PrimaryScore primaryScore;

    @Enumerated(EnumType.STRING)
    private NowStatus nowStatus;

    public Post(String todoTitle, String person, String memo, PrimaryScore primaryScore) {
        this.todoTitle = todoTitle;
        this.person = person;
        this.memo = memo;
        this.primaryScore = primaryScore;
        this.nowStatus = NowStatus.TODO;
    }


    public void changeStatus() {
        if(this.nowStatus == NowStatus.TODO){
            this.nowStatus = NowStatus.NOW_DOING;
        }
        else if(this.nowStatus == NowStatus.NOW_DOING){
            this.nowStatus = NowStatus.FINISH;
        }
    }
}
