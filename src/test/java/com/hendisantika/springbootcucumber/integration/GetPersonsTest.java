package com.hendisantika.springbootcucumber.integration;

import com.hendisantika.springbootcucumber.model.Person;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:54
 */
public class GetPersonsTest extends PersonIntegrationTest {

    private List<Person> persons;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before
    public void setup() {
        log.info("Before any test execution");
    }

    @When("I request all persons")
    public void shouldGetPersons() throws Exception {
        log.info("Running: I request all persons at " + new Date());
        persons = getPersons().collectList().block();
    }

    @Then("I validate all persons")
    public void shouldValidatePersons() throws Exception {
        log.info("Running: I validate all persons at " + new Date());

        assertEquals(5, persons.size());
        assertAll("person",
                () -> assertTrue(persons.contains(new Person("naruto", "uzumaki.naruto@konohagakure.com"))),
                () -> assertTrue(persons.contains(new Person("sasuke", "uchiha.sasuke@konohagakure.com"))),
                () -> assertTrue(persons.contains(new Person("sakura", "sakura.haruno@konohagakure.com"))),
                () -> assertTrue(persons.contains(new Person("kakashi", "hatake.kakashi@konohagakure.com"))),
                () -> assertTrue(persons.contains(new Person("minato", "minato.namikaze@konohagakure.com")))
        );
    }

    @After
    public void tearDown() {
        log.info("After all test execution");
    }

}
