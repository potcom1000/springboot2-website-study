package com.potcom1000.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ibatis나 MyBatis 등에서 Dao라고 불리는 DB layer 접근자입니다.
 * JPA에서는 Repository라고 부르며 인터페이스로 생성합니다.
 * interface를 생성하고 JpaRepository<Entity 클래스, PK타입>를 상속하면, 기본적인
 * CRUD 메소드가 자동 생성됩니다.
 * 나중에 프로젝트 규모가 커져 도메인 별로 프로젝트를 분리해야 한다면 이때 Entity 클래스와
 * 기본 Repository는 함께 위치해야 하므로 도메인 패키지에서 함께 관리합니다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
