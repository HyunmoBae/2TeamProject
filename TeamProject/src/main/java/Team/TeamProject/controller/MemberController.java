package Team.TeamProject.controller;

import Team.TeamProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sign")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    /**
     * 로그인 페이지
     */
    @GetMapping("/sign-in")
    public String signInView() {
        return "sign/sign-in";
    }

    /**
     * 회원가입 페이지
     */
    @GetMapping("/sign-up")
    public String signUpView() {
        return "sign/sign-up";
    }
}
