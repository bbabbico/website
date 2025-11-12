package project7.website.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import java.util.Date;

@Slf4j //ㅂㅈㄷ
@Controller
public class SessionInfoController {
    /**
     * session.setMaxInactiveInterval(1800); //1800초 추가하면 글로벌 세션 타임아웃 설정가능
     *
     * @sessionId : 세션Id, JSESSIONID 의 값이다. 예) 34B14F008AA3527C9F8ED620EFD7A4E1
     * @maxInactiveInterval : 세션의 유효 시간, 예) 1800초, (30분)
     * @creationTime : 세션 생성일시
     * @lastAccessedTime : 세션과 연결된 사용자가 최근에 서버에 접근한 시간, 클라이언트에서 서버로 - 요청 온걸로 세션 타임아웃 초기화 구현 가능
     * @sessionId ( JSESSIONID )를 요청한 경우에 갱신된다.
     * @isNew : 새로 생성된 세션인지, 아니면 이미 과거에 만들어졌고, 클라이언트에서 서버로
     * @sessionId ( JSESSIONID )를 요청해서 조회된 세션인지 여부
     */
    @GetMapping("/session-info") //시벨럼
    public String sessionInfo(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            model.addAttribute("result","세션이 없습니다.");
            return "index";
        }

        //세션 데이터 출력
        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name={}, value={}", name, session.getAttribute(name)));

        log.info("sessionId={}", session.getId());
        log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
        log.info("creationTime={}", new Date(session.getCreationTime()));
        log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
        log.info("isNew={}", session.isNew());
        model.addAttribute("result","세션로그 출력 완료.");
        return "index";

    }
}
