package com.potcom1000.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA Auditing 활성화
@EnableJpaAuditing
/* @SpringBootApplication
 * 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모드 자동으로 설정.
 * @SpringBootApplication이 있는 위치부터 설정을 읽으므로 프로잭트
   최상단에 위치해야한다.
 */
@SpringBootApplication
public class Application {
    /*
     * main 메소드에서 실행하는 SpringApplication.run으로 인해서 내장WAS가 실행됩니다.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
