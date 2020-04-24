package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.Discount;
import com.hendisantika.cinemabookingsystem.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/04/20
 * Time: 10.01
 */
@Controller
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping(value = "/admin/discount")
    public String allDiscount(Model model) {
        model.addAttribute("discounts", discountService.getAllDiscount());
        return "/admin/discount";
    }

    @GetMapping(value = "/discount")
    public String allDiscountUser(Model model) {
        model.addAttribute("discounts", discountService.getAllDiscount());
        return "/discount";
    }

    @GetMapping(value = "/admin/add/discount")
    public String addDiscount(Model model) {
        model.addAttribute("discount", new Discount());
        return "/admin/add/discount";
    }

    @PostMapping(value = "/admin/add/discount")
    public String addDiscount(@Valid Discount discount, BindingResult bindingResult, Model model) {
        discountService.addDiscount(discount);
        return "redirect:/admin/discount";
    }

    @GetMapping(value = "/admin/delete/discount", params = {"discountId"})
    public String deleteDiscount(@RequestParam Long discountId, Model model) {
        discountService.deleteDiscountByID(discountId);
        return "redirect:/admin/discount";
    }

    @GetMapping(value = "/admin/edit/discount", params = {"discountId"})
    public String editDiscount(@RequestParam Long discountId, Model model) {
        model.addAttribute("discount", discountService.getDiscountByID(discountId));
        return "/admin/edit/discount";
    }
}
