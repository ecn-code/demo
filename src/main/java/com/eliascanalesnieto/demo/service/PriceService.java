package com.eliascanalesnieto.demo.service;

import com.eliascanalesnieto.demo.dto.Price;
import com.eliascanalesnieto.demo.dto.PriceRequest;

public interface PriceService {

     Price getPrice(final PriceRequest priceRequest);

}
