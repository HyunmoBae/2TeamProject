package Team.TeamProject.service;

import Team.TeamProject.dto.ReviewDto;
import Team.TeamProject.entity.Board;
import Team.TeamProject.entity.Member;
import Team.TeamProject.entity.Review;
import Team.TeamProject.repository.BoardRepository;
import Team.TeamProject.repository.MemberRepository;
import Team.TeamProject.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final ReviewRepository reviewRepository;


    /**
     * 댓글 저장
     */
    public void saveReview(String review, Long board_idx, String id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        Member member = optionalMember.get();
        Optional<Board> optionalBoard = boardRepository.findById(board_idx);
        if(!optionalBoard.isPresent()) {
            throw new IllegalArgumentException("게시판을 찾을 수 없습니다.");
        }
        Board board = optionalBoard.get();

        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setContents(review);

        Review reviewEntity = Review.toReview(reviewDto, member, board);

        reviewRepository.save(reviewEntity);
    }
}
