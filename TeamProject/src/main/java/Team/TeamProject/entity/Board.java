package Team.TeamProject.entity;

import Team.TeamProject.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Board extends BaseEntity {
    // 게시판 테이블
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_idx;

    private String title; // 글 제목
    private String contents; // 글 내용
    private String category; // 카테고리
    private int hit; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member")
    private Member member;

    public static Board toBoard(BoardDto boardDto, Member member){
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        board.setCategory(board.getCategory());
        board.setHit(board.getHit());
        board.setMember(member);
        return board;
    }
}
