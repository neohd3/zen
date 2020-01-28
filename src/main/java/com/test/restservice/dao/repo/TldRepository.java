package com.test.restservice.dao.repo;

import com.test.restservice.dao.model.Tld;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TldRepository extends PagingAndSortingRepository<Tld, Long>, JpaSpecificationExecutor<Tld> {

    @EntityGraph(attributePaths = "domains")
    Page<Tld> findAll(Pageable page);
}
