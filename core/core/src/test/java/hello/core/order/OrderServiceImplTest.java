package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    // 여기서는 자바로 들어가기 때문에 스프링이 자동으로 넣어주지 않는다.
    // 그래서 setter를 쓰는 코드는 컴파일 오류가 난다.
    @Test
    void createOrder(){
        // 즉 하단의 코드는
        // 생성자 주입이 아니라, set으로 주입했을 때의 코드이다.
        // 지금 이거는 스프링이 아니라 자바로 내가 직접 new 한 거기 때문에,
        // 의존관계 주입이 일어날 수가 없다.
        // new OrderServiceImpl(); -> 이러면 NullPointException이 일어난다.
        // memberRepository, discountPolicy 의존관계 주입이 누락되었기 때문.

//        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//        memberRepository.save(new Member(1L, "item", Grade.VIP));
//
//        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
//        Order order = orderService.createOrder(1L, "itemA", 100);
//
//        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}