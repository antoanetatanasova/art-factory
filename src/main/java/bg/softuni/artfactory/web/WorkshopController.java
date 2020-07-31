package bg.softuni.artfactory.web;

import bg.softuni.artfactory.model.binding.WorkshopAddBindingModel;
import bg.softuni.artfactory.model.service.WorkshopServiceModel;
import bg.softuni.artfactory.service.WorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/workshops")
public class WorkshopController {

    private final WorkshopService workshopService;
    private final ModelMapper modelMapper;

    public WorkshopController(WorkshopService workshopService, ModelMapper modelMapper) {
        this.workshopService = workshopService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if(!model.containsAttribute("workshopAddBindingModel")) {
            model.addAttribute("workshopAddBindingModel", new WorkshopAddBindingModel());
        }
        return "workshop-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("workshopAddBindingModel")WorkshopAddBindingModel workshopAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("workshopAddBindingModel", workshopAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.workshopAddBindingModel", bindingResult);
            return "redirect:add";
        }
        this.workshopService.addWorkshop(this.modelMapper
                .map(workshopAddBindingModel, WorkshopServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id")Long id, ModelAndView modelAndView) {
        modelAndView.addObject("workshop", this.workshopService.findById(id));
        modelAndView.setViewName("workshop-details");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.workshopService.delete(id);
        return "redirect:/";
    }
}
