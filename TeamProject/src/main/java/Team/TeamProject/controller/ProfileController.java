package Team.TeamProject.controller;

import Team.TeamProject.dto.BoardDto;
import Team.TeamProject.service.BoardService;
import Team.TeamProject.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final BoardService boardService;
    /**
     * 내 글 보기 페이지
     */
    @GetMapping("/my-writing")
    public String myWritingView() {
        return "profile/my-writing";
    }

    /**
     * 내 글 목록 보여주기
     */
    @GetMapping("/my-writing/update")
    @ResponseBody
    public ResponseEntity<?> getUpdatedBoardList(@PageableDefault(size = 10) Pageable pageable,
                                                 @RequestParam String categoryId, @RequestParam String search, Principal principal) {
        try {
            String id = principal.getName();
            Page<BoardDto> boardPage = profileService.getmyBoardPage(pageable, categoryId, search, id);
            return ResponseEntity.ok(boardPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 내 글 목록 삭제
     */
    @GetMapping("/delete")
    public ResponseEntity<?> deleteMyWriting(@RequestParam Long board_idx, Principal principal) {
        try {
            boardService.deleteBoard(board_idx, principal.getName());
            return ResponseEntity.ok("글 삭제가 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 관심 목록 페이지
     */
    @GetMapping("/interest")
    public String interestView() {
        return "profile/interest";
    }

    /**
     * 회원 관리 페이지
     */
    @GetMapping("/member")
    public String memberView() {
        return "profile/member";
    }
}
