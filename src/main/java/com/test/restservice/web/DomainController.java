package com.test.restservice.web;

import com.test.restservice.service.domain.DomainFilter;
import com.test.restservice.service.domain.DomainService;
import com.test.restservice.service.domain.TldDomainDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domains")
public class DomainController {

    private final DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @GetMapping("/check")
    public List<TldDomainDTO> check(DomainFilter filter, @PageableDefault(sort = {"price"}, value = 20) Pageable page) {
        return domainService.findAll(filter, page);
    }
}
