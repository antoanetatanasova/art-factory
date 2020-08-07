package bg.softuni.artfactory.web;

import bg.softuni.artfactory.model.binding.ActivityAddBindingModel;
import bg.softuni.artfactory.model.entity.Activity;
import bg.softuni.artfactory.model.service.ActivityServiceModel;
import bg.softuni.artfactory.repository.ActivityRepository;
import bg.softuni.artfactory.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;
    private final ModelMapper modelMapper;
    private ActivityRepository activityRepository;

    public ActivityController(ActivityService activityService, ModelMapper modelMapper) {
        this.activityService = activityService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ModelAndView activity(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.addObject("activity", this.activityService.findAllActivities());
        modelAndView.setViewName("activity");
        return modelAndView;
    }

}
