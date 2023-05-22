package Team.TeamProject.controller;

import Team.TeamProject.entity.Member;
import Team.TeamProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class MemberProfileController {
    private final MemberService memberService;

    /**
     * 비밀번호 확인 페이지
     */
    @GetMapping("/check-password")
    public String checkPwView(HttpSession session){
        session.removeAttribute("changePasswordAllowed");
        return "/profile/check-password";
    }

    /**
     * 비밀번호 확인
     */
    @PostMapping("/checkPw")
    public ResponseEntity<?> checkPassword(Principal principal, @RequestParam String password, HttpSession session) {
        try{
            String id = principal.getName();
            boolean passwordMatches = memberService.checkPassword(id, password);
            if(passwordMatches) {
                session.setAttribute("changePasswordAllowed", true);
            }
            return ResponseEntity.ok().body(passwordMatches);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 비밀번호 변경 페이지
     */
    @GetMapping("/manage-profiles")
    public String changePwView(HttpSession session) {
        Boolean changePasswordAllowed = (Boolean) session.getAttribute("changePasswordAllowed");
        if (changePasswordAllowed != null && changePasswordAllowed) {
            return "/profile/manage-profiles";
        } else {
            return "redirect:/profile/check-password";
        }
    }

    /**
     * 비밀번호 변경
     */
    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(Principal principal, @RequestParam String nowPassword, @RequestParam String newPassword, HttpSession session){
        try {
            String id = principal.getName();
            boolean passwordMatches = memberService.checkPassword(id, nowPassword);
            if(!passwordMatches) {
                throw new IllegalArgumentException("현재 비밀번호가 일치하지 않습니다.");
            }
            Member changePassword = memberService.changePassword(id, nowPassword,newPassword);
            session.removeAttribute("changePasswordAllowed");
            return ResponseEntity.ok(changePassword);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 닉네임 변경
     */
}
