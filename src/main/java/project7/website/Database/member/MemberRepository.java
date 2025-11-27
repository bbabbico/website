package project7.website.Database.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 회원정보({@link Member}) DAO 인터페이스
 */
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByLoginId(String id);
}
