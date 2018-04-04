package com.minit.webservice1.service;

import com.minit.webservice1.dto.posts.PostsMainResponseDto;
import com.minit.webservice1.dto.posts.PostsSaveRequestDto;
import com.minit.webservice1.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){

        // 값을 넣은(@ResquestBody) dto객체를 이용하여 DB에 넣은 후 고유 ID값을 리턴
        return postsRepository.save(dto.toEntity()).getId();

    }

    //옵션(readOnly = true)을 주면 트랜잭션 범위는 유지하되,
    // 조회 기능만 남겨두어 조회 속도가 개선되기 때문에
    // 특별히 등록/수정/삭제 기능이 없는 메소드에선 사용하시는걸 추천드립니다.
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(){
        //.map(PostsMainResponseDto::new)는 실제로는
        // .map(posts -> new PostsMainResponseDto(posts))와 같습니다.
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
