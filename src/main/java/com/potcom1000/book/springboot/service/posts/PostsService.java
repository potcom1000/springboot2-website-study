package com.potcom1000.book.springboot.service.posts;

import com.potcom1000.book.springboot.domain.posts.Posts;
import com.potcom1000.book.springboot.domain.posts.PostsRepository;
import com.potcom1000.book.springboot.web.dto.PostsResponseDto;
import com.potcom1000.book.springboot.web.dto.PostsSaveRequestDto;
import com.potcom1000.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    // PostsService 생성자로 받아옴
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.id=" + id));

        /** update가 쿼리를 실행할 수 있는 이유
         * JPA의 영속성 컨텍스트 때문
         * 영속석 컨텍스트란, 엔티티를 영구 저장하는 환경입니다. 일종의 논리적 개념.
         * JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈립니다.
         * JPA의 EntityManager가 활성화된 상태로(Spring Data Jpa를 쓴다면 기본 옵션) 트랜잭션 안에서 데이터베이스에서
         * 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태입니다.
         * 이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이븛에 변경분을 반영합니다.
         * 즉, Entity 객체의 값만 변경하면 볋도의 Update 쿼리를 실행하지 않아도 됩니다. 이 개념을 dirty checking이라고 합니다.
         */
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.id=" + id));
        return new PostsResponseDto(entity);
    }
}
