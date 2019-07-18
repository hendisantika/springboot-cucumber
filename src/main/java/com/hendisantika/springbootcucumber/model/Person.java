package com.hendisantika.springbootcucumber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-18
 * Time: 07:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String nickname;
    private String email;

}