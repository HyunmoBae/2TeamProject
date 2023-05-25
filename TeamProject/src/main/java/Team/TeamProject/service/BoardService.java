package Team.TeamProject.service;

import Team.TeamProject.dto.BoardDto;
import Team.TeamProject.dto.ImageDto;
import Team.TeamProject.entity.Board;
import Team.TeamProject.entity.Image;
import Team.TeamProject.entity.Member;
import Team.TeamProject.repository.BoardRepository;
import Team.TeamProject.repository.ImageRepository;
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
    private final ImageRepository imageRepository;
    private final ImageService imageService;

    /**
     * 게시글 저장
     */
    public void saveBoard(BoardDto boardDto, String id) throws Exception {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        Member member = optionalMember.get();
        Board board = Board.toBoard(boardDto, member);
        List<ImageDto> imageDtos = boardDto.getImageDtos();
        List<Image> images = new ArrayList<>();
        if(imageDtos != null && !imageDtos.isEmpty()) {
            for(ImageDto imageDto : imageDtos) {
                Optional<Image> optionalImage = imageRepository.findByImgName(imageDto.getImgName());
                if (!optionalImage.isPresent()) {
                    throw new IllegalArgumentException("이미지를 찾을 수 없습니다.");
                }
                Image image = optionalImage.get();
                images.add(image);
            }
            board.setImages(images);
        }
        boardRepository.save(board);

        if(images != null && !images.isEmpty()) {
            for(Image image : images) {
                image.setBoard(board);
            }
        }
        imageService.deleteImgList();
    }

    /**
     * 게시물 상세 보기
     */
    public Board test1() {
        Optional<Board> optionalBoard = boardRepository.findByTitle("저장되지 않는 사진들");
        return optionalBoard.get();
    }
}
