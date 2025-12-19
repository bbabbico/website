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
import project7.website.Security.AuthenticatedUserService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final AuthenticatedUserService authenticatedUserService;

    @GetMapping("/company")
    public String company(@AuthenticationPrincipal Jwt jwt , Model model) {
        List<Company> companyList = companyRepository.findAll();
        model.addAttribute("companies", companyList);

        authenticatedUserService.addUserName(jwt, model);
        return  "mainmenu/company";
    }
}
