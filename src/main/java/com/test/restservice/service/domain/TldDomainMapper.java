package com.test.restservice.service.domain;

import com.test.restservice.dao.model.Domain;
import com.test.restservice.dao.model.Tld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Component
public class TldDomainMapper {

    public TldDomainDTO toDto(Tld tld, String domain) {

        if (tld == null) return null;

        log.info(tld + "");
        String domainName = tld.getDomains().isEmpty() ? null :
                tld.getDomains().stream().filter(e -> e.getName().equals(domain)).findFirst().map(Domain::getName).orElse(null);

        return new TldDomainDTO(
                domain + "." + tld.getName(),
                tld.getName(),
                !domain.equals(domainName),
                new BigDecimal(tld.getPrice()).divide(new BigDecimal(100), 2, RoundingMode.UNNECESSARY)
        );
    }
}
