package bg.softuni.artfactory.web;

import bg.softuni.artfactory.model.binding.UserLoginBindingModel;
import bg.softuni.artfactory.model.entity.UserEntity;
import bg.softuni.artfactory.model.view.AjaxResponseBody;
import bg.softuni.artfactory.repository.RoleRepository;
import bg.softuni.artfactory.service.UserManageService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("administration/users")
public class UserManageController {

    private final UserManageService userService;
    private final RoleRepository roleRepository;

    public UserManageController(UserManageService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView userAdministration(ModelAndView modelAndView) {
        modelAndView.setViewName("admin-users");
        modelAndView.addObject("users", this.userService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/administration/users";
    }

    @RequestMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editUser(@PathVariable("id") Long id, Model model) {
        userService.editUser(id);
        return "redirect:/administration/users";
    }

    @RequestMapping("/list")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/administration")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody UserLoginBindingModel userManageBindingModel, BindingResult errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<UserEntity> users = this.userService.findAll();

        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }
}
