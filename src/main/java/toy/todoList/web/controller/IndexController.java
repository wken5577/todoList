package toy.todoList.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import toy.todoList.entity.NowStatus;
import toy.todoList.service.PostService;
import toy.todoList.web.dto.CreatePostDto;
import toy.todoList.web.dto.PostResponseDto;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;

    @GetMapping("/post/new")
    public String getAddForm(Model model) {
        model.addAttribute("post", new CreatePostDto());

        return "add-form";
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        Map<NowStatus, List<PostResponseDto>> result = postService.getAllPost();

        model.addAttribute("todo", result.get(NowStatus.TODO));
        model.addAttribute("nowDoing", result.get(NowStatus.NOW_DOING));
        model.addAttribute("finish", result.get(NowStatus.FINISH));

        return "index";
    }

}
