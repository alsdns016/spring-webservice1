package com.minit.webservice1.web;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    // handlebars-spring-boot-starter(그래들설정) 때문에
    // 경로를 (prefix: src/main/resources/templates, suffix: .hbs)로 지정되
    // 따랏 main.hbs를 찾는거
    @GetMapping("/")
    public String main(){
        return "main";
    }

}
