package project7.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ServletComponentScan // 임베디드 톰캣에서 필터, 서블릿, 리스너를 빈으로 등록
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
