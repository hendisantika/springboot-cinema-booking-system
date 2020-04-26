package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.DiscountService;
import com.hendisantika.cinemabookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/04/20
 * Time: 04.12
 */
@Controller
public class UserController {

    private final UserService userService;
    private final DiscountService discountService;

    @Autowired
    public UserController(UserService userService, DiscountService discountService) {
        this.userService = userService;
        this.discountService = discountService;
    }

    @GetMapping(value = "/admin/user")
    public String allUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/admin/user";
    }

    @GetMapping(value = "/admin/edit/user", params = {"userId"})
    public String getUserEdit(@RequestParam Long userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        return "/admin/edit/user";
    }

    @PostMapping(value = "/admin/edit/user")
    public String editUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/user";
        }
        userService.update(user);
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/admin/delete/user")
    public String deleteUser(@RequestParam Long userId, Model model) {
        userService.delete(userId);
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/user")
    public String getUserDetails(Model model) {
        model.addAttribute("user", userService.findByUsername(getPrincipal()));
        model.addAttribute("allDiscounts", discountService.getAllDiscount());
        model.addAttribute("discount", new Discount());
        return "/user";
    }

    @PostMapping(value = "/user/discount")
    public String addUserDiscount(@Valid Discount discount, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/user?error";
        User user = userService.findByUsername(getPrincipal());
        userService.update(user);
        return "redirect:/user";
    }

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
