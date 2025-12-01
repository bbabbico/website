package project7.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import project7.website.login.LoginService;

@SpringBootApplication
//@ServletComponentScan // 임베디드 톰캣에서 필터, 서블릿, 리스너를 빈으로 등록
public class WebsiteApplication {

    public static void main(String[] args) {


        ApplicationContext ctx =SpringApplication.run(WebsiteApplication.class, args);
        LoginService loginService = ctx.getBean(LoginService.class); //LoginService 객체를 스프링 시작할때 미리 생성하여 JPA 연결 및 DI 활성화
    }

}
