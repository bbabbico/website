package project7.website.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project7.website.AppConfig;
import project7.website.Validtion.SignupFormValidator;
import project7.website.login.LoginForm;
import project7.website.Validtion.LoginFormValidator;
import project7.website.login.LoginService;
import project7.website.Database.member.Member;
import project7.website.session.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginFormValidator loginFormValidator;
    private final SignupFormValidator  signupFormValidator;
    
    //AppConfig 에서 가져옴
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    LoginService loginService = applicationContext.getBean("loginService", LoginService.class );

    //일반적으로 한개의 InitBinder 에 여러 검증기를 등록하면 첫번째 검증기에서 false 가 반환되면 두번째 검증기 안하고 바로 멈춤.
    /**
     * LoginForm 전용 검증기
     */
    @InitBinder("loginForm")
    public void initLoginFormBinder(WebDataBinder binder) {
        binder.addValidators(loginFormValidator);
    }
    /**
     * Member(Signup) 전용 검증기
     */
    @InitBinder("member")
    public void initMemberBinder(WebDataBinder binder) {
        binder.addValidators(signupFormValidator);
    }


    /**
     * 로그인 페이지 이동
     * @param form
     * @return login Thymeleaf 페이지
     */
    @GetMapping("/login")
    public String login(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember ,@ModelAttribute("loginForm") LoginForm form){
        //세션에 회원 데이터가 없으면 페이지 이동
        if (loginMember == null) {
            return  "login/login";
        }

        //로그인 세션 존재하면 index 리다이렉트
        return  "redirect:/";

    }

    /**
     * 회원가입 페이지 이동
     * @param member
     * @return signup Thymeleaf 페이지
     */
    @GetMapping("/signup")
    public String signup(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember ,@ModelAttribute("member") Member member){
        //세션에 회원 데이터가 없으면 페이지 이동
        if (loginMember == null) {
            return "login/signup";
        }

        //로그인 세션 존재하면 index 리다이렉트
        return  "redirect:/";

    }

    /**
     * 로그인 요청
     * @param form
     * @param bindingResult
     * @param request
     * @return 성공시 전 페이지 redirect 
     */
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL , HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {return "login/login";}

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }

        //로그인 성공 처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        //파라미터 false 하면 세션없으면 NULL 반환
        //기본 30분 타임아웃
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        //LOGIN_MEMBER 는 세션 이름
        //SessionInfoController 클래스 에서 세션 정보 확인 가능
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        //필수로 로그인이 필요한 사이트에서 redirectURL 로 갈때 member 줘야함.

        return "redirect:"+redirectURL;
    }

    /**
     * 회원가입 요청
     * @param member
     * @param bindingResult
     * @return 성공시 로그인 페이지 redirect
     */
    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {return "login/signup";}

        loginService.join(member);
        return "redirect:/login"; //리다이렉트는 컨트롤러 매핑 값으로 이동함

//        if ( == null) {
//            bindingResult.reject("loginFail", "이미 존재하는 회원입니다.");
//            return "signup";
//        }

    }

    /**
     * 로그아웃 요청
     * @param request
     * @return 성공시 전 페이지 redirect
     */
    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            log.info("로그아웃 완료");
        }
        return "redirect:/";
    }

}
