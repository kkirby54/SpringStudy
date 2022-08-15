package com.kkirby.springboot.service.posts;

import com.kkirby.springboot.domain.posts.Posts;
import com.kkirby.springboot.domain.posts.PostsRepository;
import com.kkirby.springboot.web.dto.PostsResponseDto;
import com.kkirby.springboot.web.dto.PostsSaveRequestsDto;
import com.kkirby.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestsDto requestsDto) {
        return postsRepository.save(requestsDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto updateRequestDto){
        Posts posts = postsRepository.findById(id).get();

        posts.update(updateRequestDto.getTitle(), updateRequestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).get();

        return new PostsResponseDto(entity);
    }

}
