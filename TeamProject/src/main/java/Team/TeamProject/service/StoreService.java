package Team.TeamProject.service;

import Team.TeamProject.dto.StoreDto;
import Team.TeamProject.entity.Store;
import Team.TeamProject.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    // 모든 카페 검색
    @Transactional
    public List<StoreDto> findAll() {
        List<Store> storeList = storeRepository.findAll();
        System.out.println("모든 상점정보 검색 -------- ");
        List<StoreDto> storeDtoList = new ArrayList<>();
        for (Store store:storeList){
            StoreDto dto = new StoreDto().StoreEntityToDto(store);
            storeDtoList.add(dto);
        }
        return storeDtoList;

    }

    // 카테고리에 맞는 가게 검색 ( 현모님 )
    @Transactional
    public List<StoreDto> uptaeSearch(String uptae) {

        var uptaeInfo = storeRepository.findAllByuptaeNm(uptae);
        List<StoreDto> uptaeList = new ArrayList<>();
        for (Store store:uptaeInfo){
            StoreDto dto = new StoreDto().StoreEntityToDto(store);
            uptaeList.add(dto);
        }
        return uptaeList;
    }


    // 마커 클릭했을 경우 해당 카페의 정보만 전송
    public Store sendStoreInfo(String bplcNm) {
        return storeRepository.findBybplcNm(bplcNm);
    }
}
