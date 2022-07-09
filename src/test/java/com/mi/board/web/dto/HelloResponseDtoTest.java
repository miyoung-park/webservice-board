package com.mi.board.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {

        String name = "Mi Young";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);  // assertThat : assertj 라이브러리의 테스트 검증 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
