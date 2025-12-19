package project7.website.Controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project7.website.Database.Repository.member.DuplicateMemberException;
import project7.website.Database.Repository.member.Role;
import project7.website.Database.Repository.member.Signup_type;
import project7.website.Security.JwtService;
import project7.website.Security.WebSecurityConfig;
import project7.website.Validtion.LoginForm;
import project7.website.Validtion.LoginFormValidator;
import project7.website.Validtion.SignupFormValidator;
import project7.website.Database.Repository.member.Member;
import project7.website.login.LoginServiceImpl;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginFormValidator loginFormValidator;
    private final SignupFormValidator signupFormValidator;
    private final LoginServiceImpl loginServiceImpl;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

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
     * @return login Thymeleaf 페이지 (익명 사용자만 접근가능) {@link WebSecurityConfig securityFilterChainJWT}
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login/login";
    }

    /**
     * 회원가입 페이지 이동 (익명 사용자만 접근가능) {@link WebSecurityConfig securityFilterChainJWT}
     * @return signup Thymeleaf 페이지
     */
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new Member());
        return "login/signup";
    }

    /**
     * 회원가입 요청
     * @param member 사용자 정보가 담긴 객체
     * @param bindingResult 스프링 검증 객체
     * @return 성공시 로그인 페이지 redirect
     */
    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        member.setSignup_type(Signup_type.FORM.name()); // 폼 타입으로 회원가입
        member.setRole(Role.USER);

        if (bindingResult.hasErrors()) {
            member.setPassword(null);
            return "login/signup";
        }
        try {
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            loginServiceImpl.join(member);
        } catch (DuplicateMemberException e) {
            // 필드별로 에러 붙이기
            if ("email".equals(e.getField())) {
                bindingResult.rejectValue("email", "duplicate", e.getMessage());
            } else if ("loginId".equals(e.getField())) {
                bindingResult.rejectValue("loginId", "duplicate", e.getMessage());
            } else {
                bindingResult.reject("duplicate", e.getMessage());
            }
            member.setPassword(null);
            return "login/signup";
        }

        return "redirect:/login"; //리다이렉트는 컨트롤러 매핑 값으로 이동함

    }
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm,
                        BindingResult bindingResult,
                        HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getLoginId(), loginForm.getPassword())
            );

            response.addHeader(HttpHeaders.SET_COOKIE, jwtService.Jwt(auth).toString());
        } catch (AuthenticationException e) {
            bindingResult.reject("login.failed", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "login/login";
        }

        return "redirect:/"; // 사이트 리다이렉트
    }
}
