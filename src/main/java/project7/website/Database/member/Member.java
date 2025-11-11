package project7.website.Database.member;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 회원정보 클래스
 * <p>
 * DAO 인터페이스 : {@link MemberRepository}
 */
@Data
@AllArgsConstructor //테스트 전용
public class Member {

    private Long id; //사용자 식별 번호

    private String email; //이메일
    private String loginId; //로그인 ID
    private String name; //사용자 이름
    private String password; //비밀번호
}
