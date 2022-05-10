package com.eliascanalesnieto.demo.controller;

import com.eliascanalesnieto.demo.dto.PriceRequest;
import com.eliascanalesnieto.demo.dto.PriceResponse;
import com.eliascanalesnieto.demo.mapper.PriceResponseMapper;
import com.eliascanalesnieto.demo.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/prices")
public class PriceController {

    private final PriceService priceService;
    private final PriceResponseMapper priceResponseMapper;

    @GetMapping(produces = "application/json")
    public PriceResponse getProductSimilars(@Validated final PriceRequest priceRequest) {
        return priceResponseMapper.map(priceService.getPrice(priceRequest));
    }

}
