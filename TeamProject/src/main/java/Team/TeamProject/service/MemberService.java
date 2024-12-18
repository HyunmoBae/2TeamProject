package Team.TeamProject.service;

import Team.TeamProject.dto.MemberAddressDto;
import Team.TeamProject.dto.MemberDto;
import Team.TeamProject.entity.Member;
import Team.TeamProject.entity.MemberAddress;
import Team.TeamProject.repository.MemberAddressRepository;
import Team.TeamProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final MemberAddressRepository memberAddressRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    public Member createMember(MemberDto memberDto) {
        nullCheckMember(memberDto);
        validateDuplicateMember(memberDto);
        MemberAddressDto memberAddressDto = memberDto.getMemberAddressDto();
        MemberAddress memberAddress = MemberAddress.toMemberAddress(memberAddressDto);
        memberAddress = memberAddressRepository.save(memberAddress);
        Member member = Member.toMember(memberDto, memberAddress, passwordEncoder);
        member = memberRepository.save(member);
        return member;
    }

    /**
     * 유효성 검사
     */
    private void validateDuplicateMember(MemberDto memberDto) throws DuplicateKeyException {
        Optional<Member> findMemberId = memberRepository.findById(memberDto.getId());
        Optional<Member> findMemberEmail = memberRepository.findByEmail(memberDto.getEmail());
        Optional<Member> findMemberPhoneNumber = memberRepository.findByPhoneNumber(memberDto.getPhoneNumber());
        Optional<Member> findMemberNick = memberRepository.findByNick(memberDto.getNick());
        if(findMemberId.isPresent()) {
            throw new DuplicateKeyException("아이디가 이미 존재합니다.");
        }
        if(findMemberEmail.isPresent()) {
            throw new DuplicateKeyException("이메일이 이미 존재합니다.");
        }
        if(findMemberPhoneNumber.isPresent()) {
            throw new DuplicateKeyException("이미 사용 중인 전화번호입니다");
        }
        if(findMemberNick.isPresent()) {
            throw new DuplicateKeyException("이미 사용 중인 닉네임입니다");
        }
    }

    /**
     * 빈 값 확인
     */
    private void nullCheckMember(MemberDto memberDto) throws DuplicateKeyException {
        if(memberDto.getId().isBlank()){
            throw new DuplicateKeyException("아이디를 입력하세요.");
        }
        if(memberDto.getPassword().isBlank()){
            throw new DuplicateKeyException("비밀번호를 입력하세요.");
        }
        if(memberDto.getName().isBlank()){
            throw new DuplicateKeyException("이름을 입력하세요.");
        }
        if(memberDto.getEmail().isBlank()){
            throw new DuplicateKeyException("이메일을 입력하세요.");
        }
        if(memberDto.getNick().isBlank()){
            throw new DuplicateKeyException("닉네임를 입력하세요.");
        }
        if(memberDto.getPhoneNumber().isBlank()){
            throw new DuplicateKeyException("전화번호를 입력하세요.");
        }
    }


    /**
     * 중복되는 아이디 검사
     */
    public boolean isIdExists(String id) {
        Optional<Member> findId = memberRepository.findById(id);
        return findId.isPresent();
    }

    /**
     * 중복되는 아이디 검사
     */
    public boolean isNickExists(String nick) {
        Optional<Member> findNick = memberRepository.findByNick(nick);
        return findNick.isPresent();
    }

    /**
     * Spring security 사용자, 관리자 권한 설정
     */
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findById(id);
        if(!member.isPresent()) {
            throw new UsernameNotFoundException(id);
        }

        log.info("member: {}", member);

        return User.builder()
                .username(member.get().getId())
                .password(member.get().getPassword())
                .roles(member.get().getRole().toString())
                .build();
    }
}
