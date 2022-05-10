package com.eliascanalesnieto.demo;

import com.eliascanalesnieto.demo.dto.Price;
import com.eliascanalesnieto.demo.dto.PriceResponse;
import com.eliascanalesnieto.demo.entity.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void givenPriceData_whenGetPriceFor0614At10AM_thenPriceIs35_5() {
	    URI uri = UriComponentsBuilder.fromUriString("/prices")
                .queryParam("effectiveDate", "2020-06-14T10:00:00Z")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .build()
                .toUri();

        final PriceResponse priceResponse = testRestTemplate.getForObject(uri, PriceResponse.class);
        Assertions.assertEquals(new PriceResponse(
                Price.builder()
                        .priceList(1)
                        .currency(Currency.EUR)
                        .price(35.5f)
                        .productId(35455)
                        .brandId(1)
                        .startDate("2020-06-14T00:00:00Z")
                        .endDate("2020-12-31T23:59:59Z")
                        .build()
        ), priceResponse);
    }

    @Test
    void givenPriceData_whenGetPriceFor0614At16PM_thenPriceIs35_5() {
        URI uri = UriComponentsBuilder.fromUriString("/prices")
                .queryParam("effectiveDate", "2020-06-14T16:00:00Z")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .build()
                .toUri();

        final PriceResponse priceResponse = testRestTemplate.getForObject(uri, PriceResponse.class);
        Assertions.assertEquals(new PriceResponse(
                Price.builder()
                        .currency(Currency.EUR)
                        .priceList(2)
                        .price(25.45f)
                        .productId(35455)
                        .brandId(1)
                        .startDate("2020-06-14T15:00:00Z")
                        .endDate("2020-06-14T18:30:00Z")
                        .build()
        ), priceResponse);
    }

    @Test
    void givenPriceData_whenGetPriceFor0614At21PM_thenPriceIs35_5() {
        URI uri = UriComponentsBuilder.fromUriString("/prices")
                .queryParam("effectiveDate", "2020-06-14T21:00:00Z")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .build()
                .toUri();

        final PriceResponse priceResponse = testRestTemplate.getForObject(uri, PriceResponse.class);
        Assertions.assertEquals(new PriceResponse(
                Price.builder()
                        .currency(Currency.EUR)
                        .priceList(1)
                        .price(35.5f)
                        .productId(35455)
                        .brandId(1)
                        .startDate("2020-06-14T00:00:00Z")
                        .endDate("2020-12-31T23:59:59Z")
                        .build()
        ), priceResponse);
    }

    @Test
    void givenPriceData_whenGetPriceFor0615At10AM_thenPriceIs35_5() {
        URI uri = UriComponentsBuilder.fromUriString("/prices")
                .queryParam("effectiveDate", "2020-06-15T10:00:00Z")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .build()
                .toUri();

        final PriceResponse priceResponse = testRestTemplate.getForObject(uri, PriceResponse.class);
        Assertions.assertEquals(new PriceResponse(
                Price.builder()
                        .currency(Currency.EUR)
                        .priceList(3)
                        .price(30.5f)
                        .productId(35455)
                        .brandId(1)
                        .startDate("2020-06-15T00:00:00Z")
                        .endDate("2020-06-15T11:00:00Z")
                        .build()
        ), priceResponse);
    }

    @Test
    void givenPriceData_whenGetPriceFor0616At21PM_thenPriceIs35_5() {
        URI uri = UriComponentsBuilder.fromUriString("/prices")
                .queryParam("effectiveDate", "2020-06-16T21:00:00Z")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .build()
                .toUri();

        final PriceResponse priceResponse = testRestTemplate.getForObject(uri, PriceResponse.class);
        Assertions.assertEquals(new PriceResponse(
                Price.builder()
                        .currency(Currency.EUR)
                        .priceList(4)
                        .price(38.95f)
                        .productId(35455)
                        .brandId(1)
                        .startDate("2020-06-15T16:00:00Z")
                        .endDate("2020-12-31T23:59:59Z")
                        .build()
        ), priceResponse);
    }

}
