package com.loopy.web;

//import com.loopy.config.auth.dto.SessionUser;
import com.loopy.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


//mustache는 경로 자동으로 지정됨. view resolver가 자동 처리.
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
/*
        User user = (User) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
*/
        return "index";
    }

    @GetMapping("/posts/ml")
    public String ml(){
        return "ml";
    }

    @GetMapping("/posts/dl")
    public String dl(){
        return "dl";
    }
}
