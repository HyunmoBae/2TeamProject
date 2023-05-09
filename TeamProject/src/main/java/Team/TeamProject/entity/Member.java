package Team.TeamProject.entity;

import Team.TeamProject.constant.Role;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String member_id; // 아이디
    private String member_pw; // 패스워드
    private String member_name; // 이름
    private String member_email; // 이메일
    private String member_nick; // 닉네임
    private String member_phoneNumber; // 전화번호

    @ToString.Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_address")
    private MemberAddress memberAddress; //상세주소

    @Enumerated(EnumType.STRING)
    private Role role; // 관리자 or 사용자

}
