package Team.TeamProject.controller;

import Team.TeamProject.dto.StoreDto;
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

    @GetMapping("/test")
    @ResponseBody
    public List<StoreDto> test(@RequestParam String uptae) {
        List<StoreDto> uptaeInfo = storeService.uptaeSearch(uptae);

        return uptaeInfo;
    }

}
