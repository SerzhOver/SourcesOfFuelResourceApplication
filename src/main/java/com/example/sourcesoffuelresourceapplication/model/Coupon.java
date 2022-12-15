package com.example.sourcesoffuelresourceapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coupon")
public class Coupon {

    public Coupon(long id, long userId, String type, String value) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "id_user")
    private long userId;
    @Column(name = "type")
    private String type;
    @Column(name = "value")
    private String value;
    @Column(name = "date_of_purchase")
    @Temporal(TemporalType.DATE)
    private Date dateOfPurchase;
}
