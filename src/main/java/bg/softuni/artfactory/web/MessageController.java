package bg.softuni.artfactory.web;

import bg.softuni.artfactory.model.binding.MessageSendBindingModel;
import bg.softuni.artfactory.model.service.MessageServiceModel;
import bg.softuni.artfactory.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class MessageController {

    private final MessageService messageService;
    private final ModelMapper modelMapper;

    public MessageController(MessageService messageService, ModelMapper modelMapper) {
        this.messageService = messageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public String add(Model model) {
        if(!model.containsAttribute("messageSendBindingModel")) {
            model.addAttribute("messageSendBindingModel", new MessageSendBindingModel());
        }
        return "contact";
    }

    @PostMapping()
    public String addConfirm(@Valid @ModelAttribute("messageSendBindingModel")MessageSendBindingModel messageSendBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("messageSendBindingModel", messageSendBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageSendBindingModel", bindingResult);
            return "redirect:/contact";
        }
        this.messageService.addMessage(this.modelMapper
                .map(messageSendBindingModel, MessageServiceModel.class));
        return "redirect:/contact";
    }
}
