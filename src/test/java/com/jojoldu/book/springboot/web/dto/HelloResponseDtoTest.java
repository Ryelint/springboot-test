package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokTest(){
        String name = "test";

        // 대문자
        String cmpText = "TEST";

        String caseLower = cmpText.toLowerCase();

        int amount = 1000;

//        HelloResponseDto dto = new HelloResponseDto(cmpText, amount);

        HelloResponseDto dto = new HelloResponseDto(caseLower, amount);

        // 비교
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
