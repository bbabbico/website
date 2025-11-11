package project7.website.login;

import project7.website.Database.member.Member;

import java.util.Optional;

public interface LoginService {

    Optional<Member> findByLoginId(String loginId);
    Member login(String loginId, String password);
    void join(Member member);
}
