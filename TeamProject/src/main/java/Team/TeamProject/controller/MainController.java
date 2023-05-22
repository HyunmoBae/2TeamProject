package Team.TeamProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    /**
     * 메인페이지
     */
    @GetMapping("/")
    public String main(HttpSession session) {
        session.removeAttribute("changePasswordAllowed");
        return "index";
    }
}
