package bg.softuni.artfactory.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("about")
public class AboutController {

    @GetMapping
    public ModelAndView about(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("about");
        return modelAndView;
    }

}