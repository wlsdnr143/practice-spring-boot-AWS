package com.test.code.springboot.domain.posts;

import com.test.code.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 롬복 어노테이션 (필수적인건 아님) : 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor // 롬복 어노테이션 (필수적인건 아님) : 기본 생성자 자동 추가 및 public Posts(){}와 같은 효과
@Entity // 테이블과 링크될 클래스임을 나타냄
// 기본값으로 클래스으의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
// ex) SalesManager.java -> sales_manager table
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙을 나타낸다
    private Long id;

    // @Column 어노테이션 설명
    // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    // 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    // 문자열의 경우 VARCHAR(255)기 기본값인데 사이즈를 500으로 늘리고 싶거나
    // 타입을 TEXT로 변경하고 싶거나 등의 경우에 사용된다.

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
