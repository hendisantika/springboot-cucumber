package com.hendisantika.springbootcucumber.controller;

import com.hendisantika.springbootcucumber.model.Person;
import com.hendisantika.springbootcucumber.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:47
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public Flux<Person> findAll() {
        log.info("Calling find persons");
        return personService.getAll();
    }

    @GetMapping("/{nickname}")
    public Mono<Person> findById(@PathVariable String nickname) {
        log.info("Calling find person by nickname: " + nickname);
        return personService.getByNickname(nickname);
    }

}