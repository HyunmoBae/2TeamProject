package Team.TeamProject.dto;

import Team.TeamProject.constant.Role;
import Team.TeamProject.entity.Member;
import Team.TeamProject.entity.MemberAddress;
import lombok.Data;

@Data
public class MemberDto {
    private String id; // 아이디
    private String password; // 패스워드
    private String name; // 이름
    private String email; // 이메일
    private String nick; // 닉네임
    private String phoneNumber; // 전화번호
    private Role role; // 관리자 or 사용자
    private MemberAddressDto memberAddressDto;

    public static MemberDto toMemberDto(Member member, MemberAddressDto memberAddressDto) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setPassword(member.getPassword());
        memberDto.setName(member.getName());
        memberDto.setEmail(member.getEmail());
        memberDto.setNick(member.getNick());
        memberDto.setPhoneNumber(member.getPhoneNumber());
        memberDto.setMemberAddressDto(memberAddressDto);
        memberDto.setRole(member.getRole());
        return memberDto;
    }
}
