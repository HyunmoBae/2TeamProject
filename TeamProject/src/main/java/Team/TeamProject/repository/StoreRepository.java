package Team.TeamProject.repository;

import Team.TeamProject.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    // 이름 통해서 카페 찾기
    Store findBybplcNm(String bplcNm);

    // DB 중 uptaeNm = "커피숍" 인 데이터 찾기 (카페 전체 정보)
    List<Store> findAllByuptaeNm(String uptaeNm);

    List<Store> findBybplcNmContaining(String storeName);
}
