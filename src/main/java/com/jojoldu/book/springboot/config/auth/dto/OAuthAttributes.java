package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.web.domain.user.Role;
import com.jojoldu.book.springboot.web.domain.user.User;

import java.util.Map;

public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name,
                           String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                      String userNameAttributeName,
                                      Map<String, Object> attributes) {
        String naver = "naver";
        if (naver.equals(registrationId)) {
            return ofNaver("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofNaver(
            String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");

        System.out.println("[INFO] RESPONSE : " + response);

        OAuthAttributes oAuthAttributes = new OAuthAttributes(
                response, userNameAttributeName,
                (String)response.get("name"), (String)response.get("email"),
                (String)response.get("profile_image"));

        return oAuthAttributes;
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {

        System.out.println("[INFO] attributes : " + attributes);

        OAuthAttributes oAuthAttributes = new OAuthAttributes(
                attributes, userNameAttributeName,
                (String)attributes.get("name"), (String)attributes.get("email"),
                (String)attributes.get("picture"));

        return oAuthAttributes;
    }

    public User toEntity() {

        User user = new User(name, email, picture, Role.GUEST);

        return user;
    }

    public String getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public String getName() {
        return name;
    }

    public String getNameAttributeKey() {
        return nameAttributeKey;
    }
}
