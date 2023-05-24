package Team.TeamProject.dto;

import Team.TeamProject.entity.Board;
import Team.TeamProject.entity.Image;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardDto {
    private String title; // 글 제목
    private String contents; // 글 내용
    private String category; // 카테고리
    private int count; // 조회수

    private MemberDto memberDto;

    private List<ImageDto> imageDtos;

    public static BoardDto toboardDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(board.getTitle());
        boardDto.setContents(board.getContents());
        boardDto.setCategory(board.getCategory());
        boardDto.setCount(board.getCount());
        boardDto.setMemberDto(MemberDto.toMemberDto(board.getMember()));

        List<ImageDto> imageDtos = new ArrayList<>();
        if (board.getImages() != null) {
            for (Image image : board.getImages()) {
                imageDtos.add(ImageDto.toImageDto(image));
            }
        }
        boardDto.setImageDtos(imageDtos);

        return boardDto;
    }
}
