package com.mi.board.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  Entity 클래스에서는 Setter 를 만들지 않는다.
 *  Setter 가 있을 경우 인스턴스 값들이 언제, 어디서 바꼈는지
 *  명확하게 알 수 없기 때문에..
 *  직접 setStatus(false)로 바꾸는 것이 아닌 해당 상태를 변경하는
 *  메소드를 이용하는 형태로 설계해야 한다.
 *  ex) cancel(){ this.status = false;}
 *  this.cancel();
 *
 *  Q. Setter 가 없는데 어떻게 Insert 를 할 수 있는지 ?
 *  A. 생성자를 통해 최종값을 채운 뒤 DB에 삽입하는 형태
 *  해당 Entity 클래스에서는 빌더 패턴 사용
 */
@Getter
@NoArgsConstructor
@Entity // JPA 의 어노테이션
public class Posts { // Entity 클래스

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙... IDENTITY : 붙여야 AutoIncrement 가 됨
    private Long seq; // Long : mySQL bigint 형태로 생각.

    // @Column 굳이 선언하지 않아도 되긴 하지만 사용하고 싶은 옵션이 있는 경우에 명시함
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    private String author;

    @Builder // 기본 생성자 Builder Pattern 으로 구성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
