package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.web.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }
}
