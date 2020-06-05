package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.web.domain.posts.Posts;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostsSaveRequestDto() {

    }

    public Posts toEntity() {
        Posts posts = new Posts(title, content, author);

        System.out.println("[INFO] TITLE = " + posts.getTitle());
        System.out.println("[INFO] CONTENT = " + posts.getContent());
        System.out.println("[INFO] ID = " + posts.getId());
        System.out.println("[INFO] AUTHOR = " + posts.getAuthor());

        return posts;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

}
