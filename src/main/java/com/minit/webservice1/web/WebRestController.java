package com.minit.webservice1.web;

import com.minit.webservice1.dto.posts.PostsSaveRequestDto;
import com.minit.webservice1.posts.PostsRepository;
import com.minit.webservice1.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts2")
    public void savePosts2(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){

        // postsService클래스의 save메서드는 고유ID값을 리턴하며 값이 Int형보다 클 수 있으니 Long타입으로 받는거야.
        // 리턴받은 값을 뷰(템플릿을 통해)에 리턴하겠다.
        return postsService.save(dto);
    }

}
