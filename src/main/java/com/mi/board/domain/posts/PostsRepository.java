package com.mi.board.domain.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * extends JpaRepository<`Entity 클래스`, PK 타입> 을 명시하면
 * 자동으로 CRUD 가 형성된다.
 * ** 주의 할 점은 Entity 클래스와 Entity Repository 는 함께 위치해야 한다. **
 */
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
