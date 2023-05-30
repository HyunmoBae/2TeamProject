package Team.TeamProject.service;

import Team.TeamProject.constant.BoardType;
import Team.TeamProject.dto.BoardDto;
import Team.TeamProject.dto.ReviewDto;
import Team.TeamProject.entity.Board;
import Team.TeamProject.entity.Review;
import Team.TeamProject.repository.BoardRepository;
import Team.TeamProject.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProfileService {
    private final BoardRepository boardRepository;
    private final ReviewRepository reviewRepository;

    /**
     * 내가 쓴 글 보기
     */
    public Page<BoardDto> getmyBoardPage(Pageable pageable, String categoryId, String search, String id) {
        List<Board> boards;
        if(categoryId.equals("all")) {
            if(search.isBlank()){
                boards = boardRepository.findByMemberId(id);
            } else {
                boards = boardRepository.findByMemberIdAndTitleContaining(id, search);
            }
        } else {
            if(search.isBlank()){
                boards = boardRepository.findByMemberIdAndCategory(id, categoryId);
            }
            else {
                boards = boardRepository.findByMemberIdAndCategoryAndTitleContaining(id, categoryId, search);
            }
        }

        List<Board> noticeBoards = new ArrayList<>();
        List<Board> generalBoards = new ArrayList<>();

        for (Board board : boards) {
            if (board.getBoardType() == BoardType.NOTICE) {
                noticeBoards.add(board);
            } else {
                generalBoards.add(board);
            }
        }

        Collections.reverse(noticeBoards);
        Collections.reverse(generalBoards);

        noticeBoards.addAll(generalBoards);


        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), noticeBoards.size());
        Page<Board> sortedBoardPage = new PageImpl<>(noticeBoards.subList(start, end), pageable, noticeBoards.size());

        return sortedBoardPage.map(BoardDto::toBoardDto);
    }

    /**
     * 내가 쓴 댓글 보기
     */
    public Page<ReviewDto> getMyReviewPage(Pageable pageable, String search, String id) {
        Page<Review> reviews;
        if(search.isBlank()) {
            reviews = reviewRepository.findByMemberId(pageable, id);
        } else {
            reviews = reviewRepository.findByMemberIdAndContentsContaining(pageable, id, search);
        }

        return reviews.map(ReviewDto::toReviewDto);
    }
}
