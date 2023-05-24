package Team.TeamProject.controller;

import Team.TeamProject.dto.BoardDto;
import Team.TeamProject.dto.ImageDto;
import Team.TeamProject.entity.Board;
import Team.TeamProject.service.BoardService;
import Team.TeamProject.service.ImageService;
import Team.TeamProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final MemberService memberService;
    private final BoardService boardService;
    private final ImageService imageService;

    /**
     * 글작성 페이지
     */
    @GetMapping("/writing")
    public String writingView(Model model, Principal principal) {
        try {
            String id = principal.getName();
            String nick = memberService.viewNick(id);
            model.addAttribute("nick", nick);
            return "/board/writing";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return null;
        }
    }

    /**
     * 게시글 이미지 업로드
     */
    @PostMapping("/uploadSummernoteImageFiles")
    @ResponseBody
    public ResponseEntity<List<String>> uploadSummernoteImageFiles(@RequestParam("files") MultipartFile[] files) {
        try {
            List<String> imageUrls = new ArrayList<>();

            for (MultipartFile file : files) {
                byte[] fileData = file.getBytes();
                String savedFileName = imageService.uploadFile(file.getOriginalFilename(), fileData);
                String imageUrl = "/summernote_image/" + savedFileName;
                imageUrls.add(imageUrl);
            }

            return ResponseEntity.ok(imageUrls);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonList(e.getMessage()));
        }
    }

    /**
     * 게시글 저장
     */
    @PostMapping("/saveBoard")
    public ResponseEntity<String> saveBoard(@RequestBody BoardDto boardDto, Principal principal) {
        try {
            String id = principal.getName();
            boardService.saveBoard(boardDto, id);
            return ResponseEntity.ok("게시글이 저장되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 게시글 상세보기
     */
    @GetMapping("/test")
    public ResponseEntity<?> test1() {
        Board board = boardService.test1();
        return ResponseEntity.ok().body(board.getContents());
    }
}
