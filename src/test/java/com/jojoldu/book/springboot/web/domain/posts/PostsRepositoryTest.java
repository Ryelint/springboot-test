package com.jojoldu.book.springboot.web.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void loadBoard() {
        // given
        String title = "board";
        String content = "content";

        Posts post = new Posts(title,content,"");
        postsRepository.save(post);

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntityRegister() {
        LocalDateTime now = LocalDateTime.of(2020,6,6,0,0,0);

        Posts posts = new Posts("title", "content", "author");
        postsRepository.save(posts);

        List<Posts> postsList = postsRepository.findAll();

        Posts posts1 = postsList.get(0);

        System.out.println(">>>>> createdDate = " + posts1.getCreatedDate()+
                ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts1.getCreatedDate()).isAfter(now);
        assertThat(posts1.getModifiedDate()).isAfter(now);
    }
}
