package com.example.sourcesoffuelresourceapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "id_user")
    private long userId;
    @Column(name = "card_number")
    private int cardNumber;
    @Column(name = "card_expiry_date")
    private String cardExpiryDate;
    @Column(name = "cvv")
    private int cvv;
}
