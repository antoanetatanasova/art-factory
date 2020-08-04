package bg.softuni.artfactory.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/administration")
public class AdministrationController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView administration(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("administration");
        return modelAndView;
    }
}
