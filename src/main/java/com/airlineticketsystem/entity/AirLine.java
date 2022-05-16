package com.airlineticketsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AIR_LINE")
@Getter
@Setter
public class AirLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private Integer number;

    @JsonIgnore
    @OneToMany(mappedBy="airLine")
    private List<Flight> flights;



}
