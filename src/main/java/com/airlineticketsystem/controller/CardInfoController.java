package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.CardInfoDto;
import com.airlineticketsystem.service.CardInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardInfo")
public class CardInfoController {


    private final CardInfoService cardInfoService;

    public CardInfoController(CardInfoService cardInfoService) {
        this.cardInfoService = cardInfoService;
    }

    @PostMapping("/save")
    public ResponseEntity<CardInfoDto> saveCardInfo(@RequestBody CardInfoDto cardInfoDto) {
        return new ResponseEntity<CardInfoDto>(cardInfoService.saveCardInfo(cardInfoDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CardInfoDto>> getAllCardInfo() {
        return new ResponseEntity<List<CardInfoDto>>(cardInfoService.getAllCardInfo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardInfoDto> getCardInfoById(@PathVariable(name = "id") Long cardInfoId) {
        return new ResponseEntity<CardInfoDto>(cardInfoService.getCardInfoById(cardInfoId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCardInfoById(@PathVariable(name = "id") Long cardInfoId) {
        cardInfoService.deleteCardInfoById(cardInfoId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
