package com.netology.aloch.entity;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonKey implements Serializable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(columnDefinition = "integer default 0")
    private int age;

}