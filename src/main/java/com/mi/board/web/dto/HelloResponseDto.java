package com.mi.board.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor     // final 필드가 포함된 생성자를 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}