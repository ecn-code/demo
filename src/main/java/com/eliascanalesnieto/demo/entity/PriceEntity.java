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
    Integer priceList;

    Integer productId;

    Integer brandId;

    @Enumerated(EnumType.STRING)
    @Column(name = "curr")
    Currency currency;

    Float price;

    Integer priority;

    String startDate;

    String endDate;

}
