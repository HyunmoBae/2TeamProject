package Team.TeamProject.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/index")
    public String mainProc() {
        return "index";
    }

    @GetMapping("/map")
    public String mapProc() {
        return "map";
    }

    @GetMapping("/test")
    public String testProc() {
        return "test";
    }
}
