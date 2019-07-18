package com.hendisantika.springbootcucumber.service;

import com.hendisantika.springbootcucumber.model.Person;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:49
 */
@Service
public class PersonServiceImpl implements PersonService {

    private Map<String, Person> persons = new HashMap<String, Person>();

    @PostConstruct
    public void setup() {
        Stream.of(
                new Person("naruto", "uzumaki.naruto@konohagakure.com"),
                new Person("sasuke", "uchiha.sasuke@konohagakure.com"),
                new Person("sakura", "sakura.haruno@konohagakure.com"),
                new Person("kakashi", "hatake.kakashi@konohagakure.com"),
                new Person("minato", "minato.namikaze@konohagakure.com"))
                .forEach(person -> persons.put(person.getNickname(), person));
    }

    public Flux<Person> getAll() {
        return Flux.fromIterable(persons.values());
    }

    public Mono<Person> getByNickname(String nickname) {
        return Mono.just(persons.get(nickname));
    }

}