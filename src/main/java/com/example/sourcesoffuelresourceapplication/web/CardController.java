package com.example.sourcesoffuelresourceapplication.web;

import com.example.sourcesoffuelresourceapplication.model.Card;
import com.example.sourcesoffuelresourceapplication.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(value = "pay/addNew")
    public RedirectView addNew(Card card) {
        cardService.saveCard(card);
        return new RedirectView("/my", true);
    }
}
