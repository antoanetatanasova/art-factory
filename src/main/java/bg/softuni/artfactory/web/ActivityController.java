package bg.softuni.artfactory.web;

import bg.softuni.artfactory.model.binding.ActivityAddBindingModel;
import bg.softuni.artfactory.model.service.ActivityServiceModel;
import bg.softuni.artfactory.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;
    private final ModelMapper modelMapper;

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


    @GetMapping("/add")
    public String add(Model model) {
        if(!model.containsAttribute("activityAddBindingModel")) {
            model.addAttribute("activityAddBindingModel", new ActivityAddBindingModel());
        }
        return "activity-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("activityAddBindingModel") ActivityAddBindingModel activityAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("activityAddBindingModel", activityAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.activityAddBindingModel", bindingResult);
            return "redirect:add";
        }
        this.activityService.addActivity(this.modelMapper
                .map(activityAddBindingModel, ActivityServiceModel.class));
        return "redirect:/";
    }


}