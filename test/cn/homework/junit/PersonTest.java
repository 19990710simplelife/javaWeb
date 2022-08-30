package cn.homework.junit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName PersonTest
 * @Description
 * @Author simplelife
 * @Date 2022/8/30 19:42
 * @Version 1.0
 */

public class PersonTest {
    private Person person = new Person();

    @Test
    public void eat() {
        person.eat();
    }

    @Test
    public void sleep() {
        person.sleep();
    }
}