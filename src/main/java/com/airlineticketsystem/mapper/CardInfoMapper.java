package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.CardInfoDto;
import com.airlineticketsystem.entity.CardInfo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CardInfoMapper {

    CardInfoDto entityToDto(CardInfo cardInfo);
    CardInfo convertToEntity(CardInfoDto cardInfoDto);
    List<CardInfoDto> entityToDtoList(List<CardInfo> cardInfoList);
    List<CardInfo> convertToEntityList(List<CardInfoDto> cardInfoDtoList);
}
