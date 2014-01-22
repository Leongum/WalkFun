package com.usavich.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/6/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class TestBase extends AbstractTestNGSpringContextTests {

}
