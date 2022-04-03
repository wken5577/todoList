package toy.todoList.web.dto;

import lombok.Data;
import toy.todoList.entity.PrimaryScore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class CreatePostDto {

    @NotBlank
    private String todoTitle;

    @NotBlank
    private String person;

    private String memo;

    @NotNull
    private PrimaryScore primaryTypes;

}
