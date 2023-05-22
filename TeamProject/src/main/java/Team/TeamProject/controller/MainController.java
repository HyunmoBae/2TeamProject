package Team.TeamProject.controller;

import Team.TeamProject.repository.StoreRepository;
import Team.TeamProject.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StoreRepository storeRepository;
    private final CafeService cafeService;

    /**
     * 메인페이지
     */
    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public void test() {

        System.out.println("접근하냐?");
        // 정보를 받아올려고 하니 에러가뜸;;
        cafeService.CafeSearch();


    }


}
