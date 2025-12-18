package project7.website.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project7.website.Database.Repository.member.DuplicateMemberException;
import project7.website.Database.Repository.member.Signup_type;
import project7.website.Validtion.SignupFormValidator;
import project7.website.login.LoginForm;
import project7.website.Validtion.LoginFormValidator;
import project7.website.login.LoginService;
import project7.website.Database.Repository.member.Member;
import project7.website.session.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginFormValidator loginFormValidator;
    private final SignupFormValidator  signupFormValidator;
    private final LoginService loginService;

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
     * @param form 로그인 확인용 객체
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
     * @return signup Thymeleaf 페이지
     */
    @GetMapping("/signup")
    public String signupForm(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
            @ModelAttribute("member") Member member) {

        if (loginMember != null) { // 로그인 돼 있으면 회원가입 막기
            return "redirect:/";
        }

        // @ModelAttribute("member")가 이미 new Member()를 만들어서 model에 넣어줌
        return "login/signup";
    }

    /**
     * 로그인 요청
     * @param form 로그인 정보 DTO
     * @param bindingResult 스프링 검증 객체
     * @param request 서블릿 요청 객체
     * @return 성공시 전 페이지 redirect 
     */
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL , HttpServletRequest request) {
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
     * @param member 사용자 정보가 담긴 객체
     * @param bindingResult 스프링 검증 객체
     * @return 성공시 로그인 페이지 redirect
     */
    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute("member") Member member, BindingResult bindingResult) {
        log.info(member.toString()); // 체크
        if (bindingResult.hasErrors()) {return "login/signup";}
        try {
            member.setLogin_type(Signup_type.FORM.name()); // 폼 타입으로 회원가입

            loginService.join(member);
        } catch (DuplicateMemberException e) {
            // 필드별로 에러 붙이기
            if ("email".equals(e.getField())) {
                bindingResult.rejectValue("email", "duplicate", e.getMessage());
            } else if ("loginId".equals(e.getField())) {
                bindingResult.rejectValue("loginId", "duplicate", e.getMessage());
            } else {
                bindingResult.reject("duplicate", e.getMessage());
            }
            return "login/signup";
        }

        return "redirect:/login"; //리다이렉트는 컨트롤러 매핑 값으로 이동함

    }

    /**
     * 로그아웃 요청
     * @param request 세션 정보가 담겨올 객체
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
