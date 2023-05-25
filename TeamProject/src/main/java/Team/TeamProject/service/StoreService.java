package Team.TeamProject.service;

import Team.TeamProject.entity.Store;
import Team.TeamProject.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    // 모든 카페 검색
    public List<Store> CafeSearch() {
        System.out.println("모든 카페 검색 -------- ");
        var cafeinfo = storeRepository.findAllByuptaeNm("커피숍");
//        System.err.println(cafeinfo);

        return cafeinfo;

    }


    // 마커 클릭했을 경우 해당 카페의 정보만 전송
    public Store sendCafeInfo(String bplcNm) {
        return storeRepository.findBybplcNm(bplcNm);
    }
}
