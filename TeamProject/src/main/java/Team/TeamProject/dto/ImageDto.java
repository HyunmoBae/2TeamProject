package Team.TeamProject.dto;

import Team.TeamProject.entity.Image;
import lombok.Data;

@Data
public class ImageDto {
    private String imgName; // 이미지 원본 이름
    private String imgPath; // 이미지 파일 경로

    private BoardDto boardDto;

    public static ImageDto toImageDto(Image image) {
        ImageDto imageDto = new ImageDto();
        imageDto.setImgName(image.getImgName());
        imageDto.setImgPath(image.getImgPath());
        imageDto.setBoardDto(BoardDto.toboardDto(image.getBoard()));
        return imageDto;
    }
}
