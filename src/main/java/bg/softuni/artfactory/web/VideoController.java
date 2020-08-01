package bg.softuni.artfactory.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/video")
public class VideoController {
//TODO refactor
    @GetMapping("/")
    public ModelAndView video(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("video");
        return modelAndView;
    }

}
