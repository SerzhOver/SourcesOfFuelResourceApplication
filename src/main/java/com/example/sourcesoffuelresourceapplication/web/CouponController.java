package com.example.sourcesoffuelresourceapplication.web;

import com.example.sourcesoffuelresourceapplication.model.Card;
import com.example.sourcesoffuelresourceapplication.model.Coupon;
import com.example.sourcesoffuelresourceapplication.model.User;
import com.example.sourcesoffuelresourceapplication.service.CardService;
import com.example.sourcesoffuelresourceapplication.service.CouponService;
import com.example.sourcesoffuelresourceapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CouponController {

    private final CouponService couponService;
    private final CardService cardService;
    private final UserService userService;

    @Autowired
    public CouponController(CouponService couponService, CardService cardService, UserService userService) {
        this.couponService = couponService;
        this.cardService = cardService;
        this.userService = userService;
    }

    @GetMapping("my")
    public String showAllCoupons(Model model) {
        model.addAttribute("couponsList", couponService.findAll());
        return "my";
    }


    @PostMapping(value = "coupon/addNew")
    public RedirectView addNew(Coupon coupon) {
        List<Card> cardList = cardService.findAll();
        couponService.saveCoupon(coupon);

        if (cardList.isEmpty()) {
            return new RedirectView("/pay", true);
        }

        return new RedirectView("/my", true);
    }

}