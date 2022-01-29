package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 근데 이건 그냥 생략하는 게 나을 듯.
        // 프로젝트 최상단에 둬서, 그 하위 패키지는 자동으로 탐색하도록
        // 두는 것이 관례 상 적절하다.
       //     basePackages = "hello.core.member",
       //     basePackageClasses = AutoAppConfig.class,

        // 이걸 포함하면 우리가 만든 AppConfig도 Configuration이기 때문에,
        // Component가 붙어있다(까보면). 그래서 exclude해주는 거임. 충돌하니까
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
