package com.hendisantika.springbootcucumber.integration;

import com.hendisantika.springbootcucumber.DemoApplication;
import com.hendisantika.springbootcucumber.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:53
 */
@ContextConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class PersonIntegrationTest {

    @Autowired
    private WebClient webClient;

    Flux<Person> getPersons() throws Exception {
        return webClient.get()
                .uri("/persons/")
                .retrieve()
                .bodyToFlux(Person.class);
    }

    Mono<Person> getPerson(String nickname) throws Exception {
        return webClient.get()
                .uri("/persons/" + nickname)
                .retrieve()
                .bodyToMono(Person.class);
    }

}