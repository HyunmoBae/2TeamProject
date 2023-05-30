package Team.TeamProject.controller;

import Team.TeamProject.dto.StoreDto;
import Team.TeamProject.entity.Store;
import Team.TeamProject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    StoreService storeService;

    //메인페이지
    @GetMapping("/")
    public String main() {

        return "index";
    }

    //업태검색
    @GetMapping("/uptae")
    @ResponseBody
    public List<StoreDto> searchUptae(@RequestParam String uptae) {
        List<StoreDto> uptaeInfo = storeService.searchUptae(uptae);

        return uptaeInfo;
    }

    //가게 검색
    @GetMapping("/search")
    @ResponseBody
    public List<StoreDto> searchStore(@RequestParam String storeName){
        List<StoreDto> storeInfo = storeService.searchStore(storeName);

        return storeInfo;
    }

    @GetMapping("/storeinfo")
    @ResponseBody
    public StoreDto sendCafeInfo(@RequestParam("bplcNm") String bplcNm, Model model) {

        StoreDto store = storeService.sendStoreInfo(bplcNm);

        model.addAttribute("store",store);
        return store;
    }
}
