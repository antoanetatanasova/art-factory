package bg.softuni.artfactory.web;

import bg.softuni.artfactory.service.WorkshopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final WorkshopService workshopService;

    public HomeController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.addObject("workshops", this.workshopService.findAllWorkshops());
        modelAndView.setViewName("index");
        return modelAndView;
    }

}