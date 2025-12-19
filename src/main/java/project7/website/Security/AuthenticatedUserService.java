package project7.website.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project7.website.Database.Repository.member.Member;
import project7.website.Database.Repository.member.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticatedUserService {

    private final MemberRepository memberRepository;

    public boolean addUserName(Jwt jwt, Model model) {
        if (jwt == null) {
            return false;
        }
        String name = jwt.getClaimAsString("name");
        if (name != null) {
            model.addAttribute("name", name);
        }
        return true;
    }

    public Optional<Member> findMember(Jwt jwt) {
        if (jwt == null) {
            return Optional.empty();
        }
        String loginId = jwt.getSubject();
        return memberRepository.findByLoginId(loginId);
    }
}
