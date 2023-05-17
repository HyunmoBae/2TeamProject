package Team.TeamProject.controller;

import Team.TeamProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class MemberProfileController {
    private MemberService memberService;

    /**
     * 비밀번호 확인
     */
    @GetMapping("/check-password")
    public String checkPwView(){
        return "/profile/check-password";
    }


    /**
     * 비밀번호 체크
     */
    @PostMapping("/checkPw")
    public boolean checkPassword(Principal principal, @RequestBody String password) {
        String id = principal.getName();
        boolean checkPassword = memberService.checkPassword(id, password);
        return checkPassword;
    }
}
