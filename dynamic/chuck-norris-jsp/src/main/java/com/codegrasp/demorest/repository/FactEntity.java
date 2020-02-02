package com.codegrasp.demorest.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactEntity {
    @Id
    String id;
    @Lob
    String value;
}
