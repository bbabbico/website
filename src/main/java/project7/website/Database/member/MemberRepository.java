package project7.website.Database.member;

import java.util.List;
import java.util.Optional;

/**
 * 회원정보({@link Member}) DAO 인터페이스
 */
public interface MemberRepository {
    
    Member save(Member member); //회원저장
    Member findById(Long id); //회원 식별 ID로 조회
    Optional<Member> findByLoginId(String loginId); //회원 ID로 조회
    List<Member> findAll(); //모든 회원 조회 조회

}
