package toy.todoList.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.todoList.web.dto.CreatePostDto;
import toy.todoList.service.PostService;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping("/post/new")
    public String createPost(@Validated @ModelAttribute("post") CreatePostDto createPostDto, BindingResult bindingResult) {
        if(createPostDto.getPrimary() == null){
            bindingResult.reject("NotBlank.post.primary");
        }

        if(bindingResult.hasErrors()){
            return "add-form";
        }

        postService.createPost(createPostDto.getTodoTitle(), createPostDto.getPerson(),
                createPostDto.getMemo(),createPostDto.getPrimary());

        return "redirect:/";
    }

    @PostMapping("/post/status")
    public String changeStatus(Long postId){
        postService.changeStatus(postId);
        return "redirect:/";
    }


}
