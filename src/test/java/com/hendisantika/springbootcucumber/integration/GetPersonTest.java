package com.hendisantika.springbootcucumber.integration;

import com.hendisantika.springbootcucumber.model.Person;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:58
 */
public class GetPersonTest extends PersonIntegrationTest {

    private Person person;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before
    public void setup() {
        log.info("Before any test execution");
    }

    @When("^I request person by nickname \"([^\"]*)\"$")
    public void shouldGetPersonByNickname(String nickname) throws Exception {
        log.info("Running: I request person by nickname at " + new Date());
        person = getPerson(nickname).block();
    }

    @Then("I validate person data")
    public void shouldValidatePersonData() throws Exception {
        log.info("Running: I validate person data at " + new Date());

        assertAll("person",
                () -> assertEquals("naruto", person.getNickname()),
                () -> assertEquals("uzumaki.naruto@konohagakure.com", person.getEmail())
        );
    }

    @After
    public void tearDown() {
        log.info("After all test execution");
    }

}