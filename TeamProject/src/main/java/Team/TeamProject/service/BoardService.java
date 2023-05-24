package Team.TeamProject.service;

import Team.TeamProject.dto.BoardDto;
import Team.TeamProject.dto.ImageDto;
import Team.TeamProject.entity.Board;
import Team.TeamProject.entity.Image;
import Team.TeamProject.entity.Member;
import Team.TeamProject.repository.BoardRepository;
import Team.TeamProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final ImageService imageService;

    /**
     * 게시글 저장
     */
    public void saveBoard(BoardDto boardDto, String id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        Member member = optionalMember.get();
        Board board = Board.toBoard(boardDto, member);

        // 이미지 업로드 처리
        List<ImageDto> imageDtos = boardDto.getImageDtos();
        if (imageDtos != null && !imageDtos.isEmpty()) {
            List<Image> images = new ArrayList<>();
            for (ImageDto imageDto : imageDtos) {
                try {
                    byte[] fileData = imageService.getFileDataFromUrl(imageDto.getImgPath());
                    String savedFileName = imageService.uploadFile(imageDto.getImgName(), fileData);
                    String filePath = "C:/summernote_image/" + savedFileName;

                    Image image = Image.toImage(imageDto, board);
                    image.setImgName(savedFileName);
                    image.setImgPath(filePath);
                    log.info("사진 저장");
                    images.add(image);
                } catch (Exception e) {
                    throw new RuntimeException("이미지 업로드에 실패하였습니다.", e);
                }
            }
            board.setImages(images);
        }

        boardRepository.save(board);
    }

    /**
     * 게시물 상세 보기
     */
    public Board test1() {
        Optional<Board> optionalBoard = boardRepository.findByTitle("테스트");
        return optionalBoard.get();
    }
}
