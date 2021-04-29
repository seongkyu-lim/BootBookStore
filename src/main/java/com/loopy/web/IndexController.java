package com.loopy.web;

import com.loopy.config.auth.LoginUser;
import com.loopy.config.auth.dto.SessionUser;
import com.loopy.service.posts.PostsService;
import com.loopy.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

//페이지와 관련된 컨트롤러

//mustache는 경로 자동으로 지정됨. view resolver가 자동 처리.
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/posts/ml")
    public String ml(Model model){

        model.addAttribute("posts", postsService.findAllDesc());
        return "ml";
    }

    @GetMapping("/posts/dl")
    public String dl(){
        return "dl";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
