package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.CardInfoDto;
import com.airlineticketsystem.mapper.CardInfoMapper;
import com.airlineticketsystem.repository.CardInfoRepository;
import com.airlineticketsystem.service.CardInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardInfoServiceImpl implements CardInfoService {


    private final CardInfoRepository cardInfoRepository;
    private  CardInfoMapper cardInfoMapper;

    public CardInfoServiceImpl(CardInfoRepository cardInfoRepository, CardInfoMapper cardInfoMapper) {
        this.cardInfoRepository = cardInfoRepository;
        this.cardInfoMapper = cardInfoMapper;
    }


    @Override
    public CardInfoDto saveCardInfo(CardInfoDto cardInfoDto) {
        return cardInfoMapper.entityToDto(cardInfoRepository.save(cardInfoMapper.convertToEntity(cardInfoDto)));
    }

    @Override
    public List<CardInfoDto> getAllCardInfo() {
        return cardInfoMapper.entityToDtoList(cardInfoRepository.findAll());
    }

    @Override
    public CardInfoDto getCardInfoById(Long cardInfoId) {
        return cardInfoMapper.entityToDto(cardInfoRepository.findById(cardInfoId).get());
    }

    @Override
    public void deleteCardInfoById(Long cardInfoId) {
        cardInfoRepository.deleteById(cardInfoId);
    }
}
