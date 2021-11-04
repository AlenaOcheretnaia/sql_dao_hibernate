package com.netology.aloch;

import com.netology.aloch.entity.Person;
import com.netology.aloch.entity.PersonKey;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CommandLineApp implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Slava", "Kolya", "Sergey", "Alex", "Mark", "Arkadii", "Danila", "Vova", "Kostya");
        var surnames = List.of("Ivanov", "Petrov", "Sidorov", "Vlasov", "Krainov", "Ivlev", "Samoilov", "Tuchkin", "Somov", "Kuleshov", "Rogozhin");
        var cities = List.of("Moscow", "StPeterburg", "Samara", "Kazan", "Vladivostok", "Tula", "Kaliningrad", "Omsk", "Tomsk");

        var random = new Random();
        IntStream.range(0, 50)
                .forEach(i -> {
                    var person = Person.builder()
                            .personKey(PersonKey.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .age(random.nextInt(40))
                                    .build())
                            .phoneNumber(2028889977)
                            .city(cities.get(random.nextInt(cities.size())))
                            .build();

                    entityManager.persist(person);
                });

    }
}
