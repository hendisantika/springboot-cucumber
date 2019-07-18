package com.hendisantika.springbootcucumber.service;

import com.hendisantika.springbootcucumber.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:48
 */
public interface PersonService {
    Flux<Person> getAll();

    Mono<Person> getByNickname(String nickname);
}
