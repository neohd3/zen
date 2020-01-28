package com.test.restservice.service.domain;

import com.test.restservice.dao.model.Tld;
import com.test.restservice.dao.repo.TldRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DomainService {

    private final TldRepository tldRepository;
    private final TldDomainMapper tldDomainMapper;

    public DomainService(TldRepository tldRepository, TldDomainMapper tldDomainMapper) {
        this.tldRepository = tldRepository;
        this.tldDomainMapper = tldDomainMapper;
    }

    @Transactional
    public List<TldDomainDTO> findAll(DomainFilter filter, Pageable page) {

        Page<Tld> p = tldRepository.findAll(page);
        return p.get().map(e -> tldDomainMapper.toDto(e, filter.getSearch())).collect(Collectors.toList());
    }
}