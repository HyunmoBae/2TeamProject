package Team.TeamProject.Service;

import Team.TeamProject.Repository.StoreRepository;
import Team.TeamProject.entity.Store;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void saveStore(Store store) {
        storeRepository.save(store);
    }
}

