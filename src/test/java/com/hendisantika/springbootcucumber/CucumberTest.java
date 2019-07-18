package com.hendisantika.springbootcucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:52
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class CucumberTest {
}
