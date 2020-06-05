package com.jojoldu.book.springboot.web.dto;

public class PostsUpdateRequestDto {

    private String title;
    private String content;

    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public PostsUpdateRequestDto() {}

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
