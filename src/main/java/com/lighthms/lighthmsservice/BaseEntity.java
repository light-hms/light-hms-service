package com.lighthms.lighthmsservice;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigInteger;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "bigint")
    protected BigInteger id;
}
