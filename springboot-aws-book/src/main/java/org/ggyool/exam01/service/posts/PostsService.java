package org.ggyool.exam01.service.posts;

import lombok.RequiredArgsConstructor;
import org.ggyool.exam01.domain.posts.PostsRepository;
import org.ggyool.exam01.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

}
