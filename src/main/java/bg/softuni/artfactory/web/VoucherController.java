package bg.softuni.artfactory.web;

import bg.softuni.artfactory.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/voucher")
public class VoucherController {

//    private final VoucherService voucherService;
//    private final ModelMapper modelMapper;
//
//    public VoucherController(VoucherService voucherService, ModelMapper modelMapper) {
//        this.voucherService = voucherService;
//        this.modelMapper = modelMapper;
//    }

    @GetMapping()
    public ModelAndView video(HttpSession httpSession, ModelAndView modelAndView) {
        //modelAndView.addObject("voucher", this.voucherService.findAllVouchers());
        modelAndView.setViewName("voucher");
        return modelAndView;
    }
}