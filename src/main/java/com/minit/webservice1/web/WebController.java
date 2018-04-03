package com.minit.webservice1.web;


import com.minit.webservice1.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    // handlebars-spring-boot-starter(그래들설정) 때문에
    // 경로를 (prefix: src/main/resources/templates, suffix: .hbs)로 지정되
    // 따랏 main.hbs를 찾는거
    /*@GetMapping("/")
    public String main(){
        return "main";
    }*/


    // ** DB데이터를 가져와서 웹에 뿌려주기위해 모델을 호출
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }


}
