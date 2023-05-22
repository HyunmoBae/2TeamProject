package Team.TeamProject.service;

import Team.TeamProject.dto.StoreDto;
import Team.TeamProject.entity.Store;
import Team.TeamProject.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {
    @Autowired
    private final StoreRepository storeRepository;

    @Transactional
    public List<StoreDto> findAll(){
        List<Store> storeList = storeRepository.findAll();
        List<StoreDto> storeDtoList = new ArrayList<>();
        for (Store store:storeList){
            StoreDto dto = new StoreDto().StoreEntityToDto(store);
            storeDtoList.add(dto);
        }
        return storeDtoList;
    }
}
