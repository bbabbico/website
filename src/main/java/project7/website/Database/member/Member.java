package project7.website.Database.member;
import jakarta.persistence.*;

/**
 * 회원정보 클래스
 * <p>
 * DAO 인터페이스 : {@link MemberRepository}
 */

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //사용자 식별 번호

    @Column(length = 30 , nullable = false)
    private String email; //이메일
    @Column(length = 30 , nullable = false)
    private String loginId; //로그인 ID
    @Column(length = 20 , nullable = false)
    private String name; //사용자 이름
    @Column(length = 40 , nullable = false)
    private String password; //비밀번호

}
