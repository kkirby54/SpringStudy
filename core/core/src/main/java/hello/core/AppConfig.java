package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean -> memberService -> new MemoryMemberRepository()
    // @Bean -> orderService -> new MemoryMemberRepository()
    // 띠용. 싱글톤인데 new를 두번하게 된다.
    // 근데 Configuration이 이걸 막아줌.

    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("Call AppConfig.orderService");

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 이렇게 Policy가 여러 개 있는 경우, rate, fix 처럼.
    // 이럴 때는 이렇게 하는 것보다, discountPolicyConfig 클래스를 만들어서,
    // 다시 또 수동으로 따로 관리해주는 게 유지보수 측면에서 낫다.
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
