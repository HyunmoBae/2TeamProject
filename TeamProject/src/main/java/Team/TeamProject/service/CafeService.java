package Team.TeamProject.service;

import Team.TeamProject.entity.Store;
import Team.TeamProject.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {

    private final StoreRepository storeRepository;

    public void CafeSearch() {
        System.out.println("모든 카페 검색 -------- ");
        var cafeinfo = storeRepository.findAll();
//        모든 카페 정보 찍힘 >> System.out.println(cafeinfo);

    }
}
