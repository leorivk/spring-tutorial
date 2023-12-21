package study.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.AppConfig;
import study.core.member.MemberService;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SingletonServiceTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        assertThat(instance1).isSameAs(instance2);

        instance1.logic();
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        assertThat(memberService1).isSameAs(memberService2);

    }
}