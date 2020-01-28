package com.test.restservice.dao.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "domains")
public class Domain extends AbstractEntity {

    @NotNull
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tld")
    private Tld tld;

    @Override
    public String toString() {
        return "Domain{" +
                "name='" + name + '\'' +
                ", tld=" + tld.id +
                ", id=" + id +
                '}';
    }
}