package com.potcom1000.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 여기서는 Junit의 기본 assertThat이 아닌 assertj의 assertThat을 사용했습니다.
 */
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        /** assertThat
         * assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
         * 검증하고 싶은 대상을 메소드 인자로 받습니다.
         * 메소드 체이닝을 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있습니다.
         */
        /** isEqualTo
         * assertj의 동등 비교 메소드입니다.
         * assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공합니다.
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
