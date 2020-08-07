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

import javax.validation.Valid;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("administration/activities")
public class ActivityManageController {

    private final ActivityService activityService;
    private final ModelMapper modelMapper;
    private ActivityRepository activityRepository;


    public ActivityManageController(ActivityService activityService, ModelMapper modelMapper, ActivityRepository activityRepository) {
        this.activityService = activityService;
        this.modelMapper = modelMapper;
        this.activityRepository = activityRepository;
    }

    @GetMapping
    public ModelAndView activityAdministration(ModelAndView modelAndView) {
        modelAndView.setViewName("admin-activities");
        modelAndView.addObject("activities", this.activityService.findAllActivities());
        return modelAndView;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("activityAddBindingModel")) {
            model.addAttribute("activityAddBindingModel", new ActivityAddBindingModel());
        }
        return "activity-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("activityAddBindingModel") ActivityAddBindingModel activityAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("activityAddBindingModel", activityAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.activityAddBindingModel", bindingResult);
            return "redirect:add";
        }
        this.activityService.addActivity(this.modelMapper
                .map(activityAddBindingModel, ActivityServiceModel.class));
        return "redirect:/administration/activities";
    }

    @GetMapping("administration/activities/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
//        ActivityAddBindingModel activity = activityRepository.findFirstById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//
//        model.addAttribute("activity", activity);
        return "activity-edit";
    }

    @PostMapping("administration/activities/edit/{id}")
    public String editActivity(@PathVariable("id") Long id, Activity activity,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            activity.setId(id);
            return "activity-edit";
        }
        activityRepository.save(activity);
        model.addAttribute("activities", activityRepository.findAll());
        return "redirect:/";
    }

}