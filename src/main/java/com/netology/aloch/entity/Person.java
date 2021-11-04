package com.netology.aloch.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @EmbeddedId
    private PersonKey personKey;

    private int phoneNumber;
    private String city;

    @Override
    public String toString() {
        return "Person{" +
                "personKey=" + personKey +
                ", phoneNumber=" + phoneNumber +
                ", city='" + city + '\'' +
                '}'+ "<br>";
    }
}
