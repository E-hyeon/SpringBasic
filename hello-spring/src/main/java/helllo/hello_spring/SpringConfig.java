package helllo.hello_spring;

import helllo.hello_spring.repository.MemberRepository;
import helllo.hello_spring.repository.MemoryMemberRepository;
import helllo.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
