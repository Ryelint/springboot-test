package com.jojoldu.book.springboot.web.domain.user;

public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private String key;
    private String title;

    Role(String key, String title) {
        this.key = key;
        this.title = title;
    }

    Role(){}

    public String getTitle() {
        return title;
    }

    public String getKey() {
        return key;
    }
}
