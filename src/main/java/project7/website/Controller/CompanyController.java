package project7.website.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project7.website.Database.Repository.Company.Company;
import project7.website.Database.Repository.Company.CompanyRepository;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyRepository companyRepository;

    @GetMapping("/company")
    public String company(@AuthenticationPrincipal Jwt jwt , Model model) {
        List<Company> companyList = companyRepository.findAll();
        model.addAttribute("companies", companyList);

        if (jwt != null) { //로그인 세션 존재하면 view 전달
            String name = jwt.getClaimAsString("name");
            model.addAttribute("name", name);
        } else {
            return "mainmenu/company"; //세션에 회원 데이터가 없으면 빈 Model 전달
        }
        return  "mainmenu/company";
    }
}
