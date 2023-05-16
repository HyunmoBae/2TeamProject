package Team.TeamProject.controller;

import Team.TeamProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class MemberProfileController {
    private MemberService memberService;

    /**
     * 프로필 관리 비밀번호 확인
     */
}
