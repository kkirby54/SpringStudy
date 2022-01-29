package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    // 이렇게 필드로 넣으면,
    // 스프링이 처리하지 않고 내가 그냥 자바를 이용해서 OrderServiceImpl 객체를
    // 만들 방법이 없다.
    // 그러려면 결국 OrderServiceImpl에서 setter 등을 만들어서 해야 한다.
    @Test
    void fieldInjectionTest(){
    //    OrderServiceImpl orderService = new OrderServiceImpl();
    //    orderService.createOrder(1L, "itemA", 10000);

    }

}
