package project7.website.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project7.website.Database.Repository.Company.Company;
import project7.website.Database.Repository.Company.CompanyRepository;
import project7.website.Database.Repository.member.Member;
import project7.website.session.SessionConst;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyRepository companyRepository;

    @GetMapping("/company")
    public String company(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember , Model model) {
        List<Company> companyList = companyRepository.findAll();
        model.addAttribute("companies", companyList);

        //세션에 회원 데이터가 없으면 빈 Model 전달
        if (loginMember == null) {
            return  "mainmenu/company";
        }

        //로그인 세션 존재하면 view 전달
        model.addAttribute("member", loginMember);
        return  "mainmenu/company";

    }
}
