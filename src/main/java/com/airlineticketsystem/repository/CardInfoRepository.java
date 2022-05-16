package com.airlineticketsystem.repository;

import com.airlineticketsystem.entity.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
}