package com.eliascanalesnieto.demo.repository;

import com.eliascanalesnieto.demo.dto.PriceRequest;
import com.eliascanalesnieto.demo.entity.PriceEntity;

public interface PriceRepository {

    PriceEntity getPrice(final PriceRequest priceRequest);

}
