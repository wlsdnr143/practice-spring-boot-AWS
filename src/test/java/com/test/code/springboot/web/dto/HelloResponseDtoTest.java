package com.test.code.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat; //assertj의 assertThat 사용
//Junit과 assertj의 "assertThat" 차이
// Junit은 is()와 같이 CoreMatchers 라이브러리가 필요하지만 assertj는 필요없음
// 자동완성이 좀 더 확실하게 지원됨

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
