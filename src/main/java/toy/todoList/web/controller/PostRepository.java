package toy.todoList.web.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import toy.todoList.entity.Post;
import toy.todoList.web.dto.PostResponseDto;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


}
