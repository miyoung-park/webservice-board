package com.mi.board.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void getDetailBoard(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // save : Posts 에 Insert/Update 쿼리 실행
        // PK_ID 값이 없다면 Insert , 있다면 Update
        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("qkraldud1529@gmail.com")
                        .build());

        // Posts 테이블에 있는 모든 데이터 조회
        List<Posts> listPosts = postsRepository.findAll();
        Posts posts = listPosts.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        System.out.println( "posts :::: " + posts );
    }

}
