package Team.TeamProject.controller;

import Team.TeamProject.dto.StoreDto;
import Team.TeamProject.entity.Store;
import Team.TeamProject.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StoreService storeService;

    /**
     * 메인페이지
     */
    @GetMapping("/")
    public String main() {
        return "index";
    }

    //  현모
    @GetMapping("/test")
    @ResponseBody
    public List<StoreDto> test(@RequestParam String uptae) {
        List<StoreDto> uptaeInfo = storeService.uptaeSearch(uptae);
//        System.err.println(uptaeInfo);

        return uptaeInfo;
    }

    // 마커 클릭했을 경우 해당 마커의 카페 정보 전송
    @RequestMapping("/storeinfo")
    @ResponseBody
    public Store sendCafeInfo(@RequestParam("bplcNm") String bplcNm,Model model) {

        Store store = storeService.sendStoreInfo(bplcNm);
        System.out.println(bplcNm+"의 정보 요청");

        System.out.println("가게정보 ----- \n"+store);
        model.addAttribute("store",store);
        return store;
    }




}
