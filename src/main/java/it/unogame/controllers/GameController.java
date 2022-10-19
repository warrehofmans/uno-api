package it.unogame.controllers;

import it.unogame.model.Card;
import it.unogame.services.IRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GameController {
    private final IRules rules;

    @Autowired
    public GameController(IRules rules) {
        this.rules = rules;
    }

    @PostMapping("/start")
    public HttpStatus startGame(@RequestBody Card[] cards){
        this.rules.startGame(cards);
        return HttpStatus.OK;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getCards(){
        return new ResponseEntity<>(this.rules.getCards(), HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<Boolean> checkRules(@RequestBody Card[] cards){
        return new ResponseEntity<>(this.rules.canCardBePlayed(cards[0],cards[1]), HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpStatus addCard(@RequestBody Card card){
        this.rules.addCard(card);
        return HttpStatus.OK;
    }

    @PostMapping("/remove")
    public HttpStatus removeCard(@RequestBody Card card){
        this.rules.removeCard(card);
        return HttpStatus.OK;
    }
}
