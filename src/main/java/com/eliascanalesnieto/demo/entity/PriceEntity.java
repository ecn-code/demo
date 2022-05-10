package com.eliascanalesnieto.demo.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = PriceEntity.TABLE_NAME)
public class PriceEntity {

    static final String TABLE_NAME = "PRICES";

    @Id
    private Integer priceList;

    private Integer productId;

    private Integer brandId;

    @Enumerated(EnumType.STRING)
    @Column(name = "curr")
    private Currency currency;

    private Float price;

    private Integer priority;

    private String startDate;

    private String endDate;

}
