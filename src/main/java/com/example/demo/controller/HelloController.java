package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        // Model 객체에 'data'라는 이름으로 값을 담아 템플릿으로 전달합니다.
        model.addAttribute("data", "Thymeleaf를 통해 서버에서 전달된 메시지입니다.");

        // 반환하는 문자열 ("hello")은 templates/hello.html 파일을 찾으라는 의미입니다.
        return "hello";
    }
}