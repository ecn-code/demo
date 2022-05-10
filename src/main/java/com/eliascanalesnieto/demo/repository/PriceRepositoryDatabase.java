package com.eliascanalesnieto.demo.repository;

import com.eliascanalesnieto.demo.dto.PriceRequest;
import com.eliascanalesnieto.demo.entity.PriceEntity;
import com.eliascanalesnieto.demo.entity.PriceEntity_;
import com.eliascanalesnieto.demo.exception.NotFound;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Repository
public class PriceRepositoryDatabase implements PriceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PriceEntity getPrice(PriceRequest priceRequest) {

        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<PriceEntity> query = cb.createQuery(PriceEntity.class);
        final Root<PriceEntity> root = query.from(PriceEntity.class);

        Set<Predicate> predicates = new HashSet<>(4);
        if (Objects.nonNull(priceRequest.getBrandId())) {
            predicates.add(cb.equal(root.get(PriceEntity_.brandId), priceRequest.getBrandId()));
        }

        if (Objects.nonNull(priceRequest.getEffectiveDate())) {
            predicates.add(cb.lessThanOrEqualTo(root.get(PriceEntity_.startDate),
                    priceRequest.getEffectiveDate()));
            predicates.add(cb.greaterThan(root.get(PriceEntity_.endDate),
                    priceRequest.getEffectiveDate()));
        }

        if (Objects.nonNull(priceRequest.getProductId())) {
            predicates.add(cb.equal(root.get(PriceEntity_.productId), priceRequest.getProductId()));
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        List<Order> orderList = new ArrayList();
        orderList.add(cb.desc(root.get("priority")));
        query.orderBy(orderList);

        return entityManager.createQuery(query)
                .getResultStream()
                .findFirst()
                .orElseThrow(() -> new NotFound());
    }
}
