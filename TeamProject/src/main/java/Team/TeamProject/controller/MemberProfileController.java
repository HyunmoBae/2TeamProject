package Team.TeamProject.controller;

import Team.TeamProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Boolean> checkPassword(Principal principal, @RequestBody String password) {
        String id = principal.getName();
        log.info("id = {}", id);
        log.info("password = {}", password);
        boolean passwordMatches = memberService.checkPassword(id, password);
        return ResponseEntity.ok(passwordMatches);
    }

    /**
     * 비밀번호 변경 페이지
     */
    @GetMapping("/change-password")
    public String changePwView() {
        return "/profile/change-password";
    }
}
