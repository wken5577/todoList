package toy.todoList.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class CreatePostDto {

    @NotBlank
    private String todoTitle;

    @NotBlank
    private String person;

    private String memo;

    private Integer primary;

}
