package com.test.restservice.service.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class TldDomainDTO {
    private String domain;
    private String tld;
    private Boolean available;
    private BigDecimal price;
}