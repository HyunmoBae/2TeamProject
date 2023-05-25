package Team.TeamProject.repository;

import Team.TeamProject.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByImgName(String imgName);
}
