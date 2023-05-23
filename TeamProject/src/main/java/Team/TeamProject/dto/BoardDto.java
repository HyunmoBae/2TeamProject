package Team.TeamProject.dto;

import Team.TeamProject.entity.Board;
import lombok.Data;

@Data
public class BoardDto {
    private String title; // 글 제목
    private String contents; // 글 내용
    private String category; // 카테고리
    private int hit; // 조회수

    private MemberDto memberDto;

    public static BoardDto boardDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(board.getTitle());
        boardDto.setContents(board.getContents());
        boardDto.setCategory(board.getCategory());
        boardDto.setHit(board.getHit());
        boardDto.setMemberDto(MemberDto.toMemberDto(board.getMember()));
        return boardDto;
    }
}
