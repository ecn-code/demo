package com.eliascanalesnieto.demo.mapper;

import com.eliascanalesnieto.demo.dto.Price;
import com.eliascanalesnieto.demo.dto.PriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceResponseMapper {

    public PriceResponse map(final Price price) {
        return new PriceResponse(price);
    }

}
