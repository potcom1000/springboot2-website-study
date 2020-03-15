package com.potcom1000.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Setter 메소드를 안만드는 이유
   자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는 경우가 있습니다.
   이렇게 되면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어,
   차후 기능 변경 시 정말 복잡해집니다.
   그래서 Entity 클래스에서는 절대로 Setter 메소드를 만들지 않습니다. 대신, 해당 필드의 값 변경이
   필요하면 명확히 그 목적과 의도를 나타낼 수 있는 매소드를 추가해야만 합니다.
 */

/**
 * 주요 어노테이션은 클래스와 가까이 둬라
 * 나중에 코틀린 등의 새 언어 전환으로 롬복이 필요없을 경우 쉽게 삭제할 수 있습니다.
  */
@Getter
@NoArgsConstructor
/**
 * 테이블과 링크될 클래스임을 나타냄
 * 기본값으로 클래스의 카멜케이스 이름을 언더스코어 내이밍(_)으로 테이블 이름을 매칭합니다.
   ex) SalesManager.java -> sales_manager table
 */
@Entity
public class Posts extends BaseTimeEntity {

    // 해당 테이블의 PK필드
    @Id
    /**
     * PK의 생성규칙을 나타냅니다.
     * 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야지만 auto_increment가 된다.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content =  content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
