package com.example.sourcesoffuelresourceapplication.service;

import com.example.sourcesoffuelresourceapplication.model.Coupon;
import com.example.sourcesoffuelresourceapplication.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon saveCoupon(Coupon coupon) {
        Date now = new Date();
        coupon.setDateOfPurchase(now);
        coupon.setUserId(1);
        return couponRepository.save(coupon);
    }

    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }
}
