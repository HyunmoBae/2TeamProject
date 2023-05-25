package Team.TeamProject.controller;

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

    private final StoreService cafeService;

    /**
     * 메인페이지
     */
    @GetMapping("/")
    public String main() {
        return "index";
    }


    // 카페의 모든 정보 받는지 확인용도
    @GetMapping("/test")
    @ResponseBody
    public List<Store> test(Model model) {

        List<Store> cafeInfo = cafeService.CafeSearch();
        // List 로 넘기고 List 로 원하는 정보만 받음 될듯
//        System.err.println(cafeInfo);
        model.addAttribute("cafeInfo",cafeInfo);
//        System.err.println(cafeInfo.get(1).getBplcNm());

        return cafeInfo;
    }

    // 마커 클릭했을 경우 해당 마커의 카페 정보 전송
    @RequestMapping("/cafeinfo")
    @ResponseBody
    public Store sendCafeInfo(@RequestParam("bplcNm") String bplcNm,Model model) {

        Store cafe = cafeService.sendCafeInfo(bplcNm);
        System.out.println(bplcNm+"의 정보 요청");

        System.out.println("카페정보 ----- \n"+cafe);
        model.addAttribute("cafe",cafe);
        return cafe;
    }


}
