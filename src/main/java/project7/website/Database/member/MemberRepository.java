package project7.website.Database.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 회원정보({@link Member}) DAO 인터페이스
 */
public interface MemberRepository extends JpaRepository<Member, Integer> {
    
    Member save(Member member); //회원저장
    Member findById(int id); //회원 식별 ID로 조회
    Optional<Member> findByLoginId(String loginId); //회원 ID로 조회
    List<Member> findAll(); //모든 회원 조회 조회

}
