package Team.TeamProject.controller;

import Team.TeamProject.dto.BoardDto;
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
    /**
     * 내 글 보기 페이지
     */
    @GetMapping("/my-writing")
    public String myWritingView() {
        return "profile/my-writing";
    }

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

    @PostMapping("/my-writing/delete")
    public String deleteMyWriting(@RequestBody List<Long> checkedValues) {
        log.info("checkedValues: {}", checkedValues);
        for (Long board_idx : checkedValues) {
            log.info("board_idx: {}", board_idx);
        }
        return "profile/my-writing";
    }

}
