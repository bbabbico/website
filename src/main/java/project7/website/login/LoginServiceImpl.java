package project7.website.login;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project7.website.Database.Repository.member.DuplicateMemberException;
import project7.website.Database.Repository.member.Member;
import project7.website.Database.Repository.member.MemberRepository;

import java.util.Optional;

@Service
public class LoginServiceImpl {

    private final MemberRepository memberRepository;

    @Autowired
    public LoginServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // TODO : 시큐리티로 수정 됨.
    @Transactional
    public void join(Member member) {
        // 이메일 중복 체크
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new DuplicateMemberException("email", "이미 사용 중인 이메일입니다.");
        }

        // 로그인ID 중복 체크
        if (memberRepository.existsByLoginId(member.getLoginId())) {
            throw new DuplicateMemberException("loginId", "이미 사용 중인 로그인 ID입니다.");
        }

        memberRepository.save(member);
    }

    public Optional<Member> findByLoginId(String loginId){
        return memberRepository.findByLoginId(loginId);
    }

}
