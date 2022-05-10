package com.eliascanalesnieto.demo.dto;

import com.eliascanalesnieto.demo.entity.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private Integer priceList;

    private Integer productId;

    private Integer brandId;

    private Currency currency;

    private Float price;

    private String startDate;

    private String endDate;

}
