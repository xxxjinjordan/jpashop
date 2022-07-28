package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    /*
        객체지향스럽지 못한 필드
        객체 설계를 테이블 설계에 맞춘 방식
        테이블의 외래키를 객체에 그대로 가져옴
        객체 그래프 탐색이 불가능
        참조가 없으므로 UML도 잘못됨

        -> 연관관계 매핑을 통해 객체를 필드로 가져보자 !
     */
    @Column(name="member_id")
    private Long memberId;

    private LocalDateTime orderDate;

    // ORDINAL 사용시 순서가 꼬여서 큰 장애가 날 수 있다.
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
