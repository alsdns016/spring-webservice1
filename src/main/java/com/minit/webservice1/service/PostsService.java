package com.minit.webservice1.service;

import com.minit.webservice1.dto.posts.PostsSaveRequestDto;
import com.minit.webservice1.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){

        // 값을 넣은(@ResquestBody) dto객체를 이용하여 DB에 넣은 후 고유 ID값을 리턴
        return postsRepository.save(dto.toEntity()).getId();

    }

}
