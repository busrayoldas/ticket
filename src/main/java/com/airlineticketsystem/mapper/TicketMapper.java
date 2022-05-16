package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.TicketDto;
import com.airlineticketsystem.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TicketMapper {

    TicketDto entityToDto(Ticket ticket);
    Ticket convertToEntity(TicketDto ticketDto);
    List<TicketDto> entityToDtoList(List<Ticket> ticketList);
    List<Ticket> convertToEntityList(List<TicketDto> ticketDtoList);
}
