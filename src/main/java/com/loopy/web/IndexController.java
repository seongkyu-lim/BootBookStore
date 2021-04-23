package com.loopy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//mustache는 경로 자동으로 지정됨. view resolver가 자동 처리.
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
