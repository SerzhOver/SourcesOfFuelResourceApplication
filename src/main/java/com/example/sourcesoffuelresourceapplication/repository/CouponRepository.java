package com.example.sourcesoffuelresourceapplication.repository;

import com.example.sourcesoffuelresourceapplication.model.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

    List<Coupon> findAll();

}
