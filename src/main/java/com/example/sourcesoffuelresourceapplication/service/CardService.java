package com.example.sourcesoffuelresourceapplication.service;

import com.example.sourcesoffuelresourceapplication.model.Card;
import com.example.sourcesoffuelresourceapplication.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card saveCard(Card card) {
        card.setUserId(1);
        return cardRepository.save(card);
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}
