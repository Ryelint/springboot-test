package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.web.domain.posts.Posts;
import com.jojoldu.book.springboot.web.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public PostsService() {

    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        Posts entity = requestDto.toEntity();

        System.out.println("[INFO] entity = " + entity);

        return postsRepository.save(entity).getId();
    }
}
