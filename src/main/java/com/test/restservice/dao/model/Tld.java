package com.test.restservice.dao.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tlds")
public class Tld extends AbstractEntity {
    @NotNull
    private String name;
    @NotNull
    private Long price; // money should always be stored as integer to avoid floating-point issues in the future
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tld")
    private List<Domain> domains;
}