package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.CardInfoDto;

import java.util.List;


public interface CardInfoService {


    CardInfoDto saveCardInfo(CardInfoDto cardInfoDto);

    List<CardInfoDto> getAllCardInfo();

    CardInfoDto getCardInfoById(Long cardInfoId);

    void deleteCardInfoById(Long cardInfoId);
}
