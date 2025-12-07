package project7.website.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project7.website.Database.Repository.member.Member;
import project7.website.Database.Repository.member.MemberRepository;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final MemberRepository memberRepository;

    @Autowired
    public LoginServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    @Override
    public Optional<Member> findByLoginId(String loginId){
        return memberRepository.findByLoginId(loginId);
    }

    /**
     * @return null 로그인 실패
     */
    @Override
    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
