package com.eliascanalesnieto.demo.service;

import com.eliascanalesnieto.demo.dto.Price;
import com.eliascanalesnieto.demo.dto.PriceRequest;
import com.eliascanalesnieto.demo.mapper.PriceMapper;
import com.eliascanalesnieto.demo.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    @Override
    public Price getPrice(final PriceRequest priceRequest) {
        return this.priceMapper.map(
                priceRepository.getPrice(priceRequest)
        );
    }

}
