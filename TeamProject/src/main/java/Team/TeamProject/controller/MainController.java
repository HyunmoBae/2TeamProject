package Team.TeamProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
     * 메인페이지
     */
    @GetMapping("/")
    public String main() {
        return "index";
    }
}
