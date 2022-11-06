package kz.bitlab.TrelloTask;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/")
public class MainController {

    @GetMapping(value = "/")
    public String getMainPage() {
        return "redirect:/folders";
    }
}
