package bg.softuni.artfactory.web;

import bg.softuni.artfactory.model.binding.VideoAddBindingModel;
import bg.softuni.artfactory.model.service.VideoServiceModel;
import bg.softuni.artfactory.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;
    private final ModelMapper modelMapper;

    public VideoController(VideoService videoService, ModelMapper modelMapper) {
        this.videoService = videoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ModelAndView video(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.addObject("video", this.videoService.findAllVideos());
        modelAndView.setViewName("video");
        return modelAndView;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if(!model.containsAttribute("videoAddBindingModel")) {
            model.addAttribute("videoAddBindingModel", new VideoAddBindingModel());
        }
        return "video-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("videoAddBindingModel") VideoAddBindingModel videoAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("videoAddBindingModel", videoAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.videoAddBindingModel", bindingResult);
            return "redirect:add";
        }
        this.videoService.addVideo(this.modelMapper
                .map(videoAddBindingModel, VideoServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/tutorial")
    public ModelAndView details(@RequestParam("id")Long id, ModelAndView modelAndView) {
        modelAndView.addObject("video", this.videoService.findById(id));
        modelAndView.setViewName("video-tutorial");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.videoService.delete(id);
        return "redirect:/";
    }

}