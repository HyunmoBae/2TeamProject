package Team.TeamProject.controller;

import Team.TeamProject.dto.MemberDto;
import Team.TeamProject.entity.Member;
import Team.TeamProject.repository.MemberRepository;
import Team.TeamProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/sign")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

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

    /**
     * 회원가입
     */
    @PostMapping("/register")
    public ResponseEntity<?> saveMember(@RequestBody MemberDto memberDto, HttpServletResponse response) {
        log.info("memberDto: {}", memberDto);
        if(memberDto.getId().isBlank()){
            log.info("-------------------null--------------------");
        }
        try {
            Member saveMember = memberService.createMember(memberDto);
            response.sendRedirect("/sign/sign-in");
            return ResponseEntity.ok(saveMember);
        } catch (DuplicateKeyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Redirect Error");
        }
    }

    /**
     *  로그인 확인
     */
    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        log.info("username: {}", principal);
        return principal.getName();
    }

    /**
     * 로그인 에러 알림
     */
    @GetMapping("/sign-in/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        log.info("model: {}", model);
        return "sign/sign-in";
    }

    /**
     * 실시간 아이디 체크
     */
    @PostMapping("/id_check")
    public ResponseEntity<Map<String, Object>> checkId(@RequestParam String id) {
        Map<String, Object> response = new HashMap<>();
        boolean isExists = memberService.isIdExists(id);
        if (id.isBlank()) {
            response.put("message", "빈 값입니다.");
        } else if (isExists) {
            response.put("message", "아이디가 이미 존재합니다.");
        } else {
            response.put("message", "사용 가능한 아이디입니다.");
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 실시간 닉네임 체크
     */
    @PostMapping("/nick_check")
    public ResponseEntity<Map<String, Object>> checkNick(@RequestParam String nick) {
        Map<String, Object> response = new HashMap<>();
        boolean isExists = memberService.isIdExists(nick);
        if(nick.isBlank()) {
            response.put("message", "빈 값입니다.");
        } else if (isExists) {
            response.put("message", "닉네임이 이미 존재합니다.");
        } else {
            response.put("message", "사용 가능한 닉네임입니다.");
        }
        return ResponseEntity.ok(response);
    }
}
