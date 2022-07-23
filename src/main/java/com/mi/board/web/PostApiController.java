package com.mi.board.web;

import com.mi.board.service.posts.PostsService;
import com.mi.board.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 을 반환하는 컨트롤러 생성( @Controller + @ResponseBody )
@RequiredArgsConstructor // 생성자 주입방식
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save( @RequestBody PostsSaveRequestDto requestDto ){
        return postsService.save(requestDto);
    }

}
