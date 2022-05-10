package com.eliascanalesnieto.demo.mapper;

import com.eliascanalesnieto.demo.dto.Price;
import com.eliascanalesnieto.demo.entity.PriceEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price map(final PriceEntity product);

}