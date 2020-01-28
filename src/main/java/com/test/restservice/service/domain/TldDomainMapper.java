package com.test.restservice.service.domain;

import com.test.restservice.dao.model.Tld;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class TldDomainMapper {

    public TldDomainDTO toDto(Tld tld, String domain) {

        if (tld == null) return null;

        String domainName = tld.getDomains().isEmpty() ? null : tld.getDomains().get(0).getName();

        return new TldDomainDTO(
                domain + "." + tld.getName(),
                tld.getName(),
                !domain.equals(domainName),
                new BigDecimal(tld.getPrice()).divide(new BigDecimal(100), 2, RoundingMode.UNNECESSARY)
        );
    }
}
