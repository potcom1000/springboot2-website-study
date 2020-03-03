package com.potcom1000.book.springboot.web;

import com.potcom1000.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * 컨트롤러를 JSON을 반환하는 컨트롤러로 설정합니다.
 * 과거에는 @ResponseBody를 각 메소드마다 반환형 앞에 선언했던 것을 한번에 사용할 수 있게 합니다.
 */
@RestController
public class HelloController {

    // HTTP method인 Get 요청을 받는 API입니다.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name
            , @RequestParam("amount") int amount ){
        return new HelloResponseDto(name, amount);
    }
}
