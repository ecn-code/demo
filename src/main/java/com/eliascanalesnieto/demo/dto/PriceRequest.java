package com.eliascanalesnieto.demo.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;

@Data
public class PriceRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    final String effectiveDate;

    @Positive
    final Integer productId;

    @Positive
    final Integer brandId;

}
