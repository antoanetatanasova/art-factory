package bg.softuni.artfactory.web;

import bg.softuni.artfactory.model.binding.UserRegistrationBindingModel;
import bg.softuni.artfactory.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;

    @GetMapping("/registration")
    public String showRegister(Model model) {
        model.addAttribute("formData", new UserRegistrationBindingModel());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute("formData") UserRegistrationBindingModel userRegistrationBindingModel,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (userService.existsUser(userRegistrationBindingModel.getEmail())) {
            bindingResult.rejectValue("email",
                    "error.email",
                    "An account with this email already exists.");
            return "registration";
        }

        userService.createAndLoginUser(userRegistrationBindingModel.getEmail(), userRegistrationBindingModel.getPassword());

        return "redirect:/";
    }

}