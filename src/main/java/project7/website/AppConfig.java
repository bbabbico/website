package project7.website;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project7.website.Database.member.MemberRepository;
import project7.website.Database.member.MemberRepositoryT;
import project7.website.login.LoginCheckFilter;
import project7.website.login.LoginService;
import project7.website.login.LoginServiceImpl;
@Configuration
public class AppConfig implements WebMvcConfigurer {

    /**
     * 회원정보 DAO 인터페이스 : {@link MemberRepository}
     * <p>
     * DAO 구현체 : {@link MemberRepositoryT}
     * @return 구현체
     */
    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryT();
    }

    /**
     * 로그인 서비스 인터페이스 : {@link LoginService}
     * <p>
     * 로그인 서비스 구현체 : {@link LoginServiceImpl}
     * @return 구현체
     */
    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl(memberRepository());
    }

    /**
     * 로그인 확인 필터
     *
     */
    @Bean
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
